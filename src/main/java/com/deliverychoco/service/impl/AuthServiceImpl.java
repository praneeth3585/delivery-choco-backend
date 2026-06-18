package com.deliverychoco.service.impl;

import com.deliverychoco.dto.AuthResponse;
import com.deliverychoco.dto.LoginRequest;
import com.deliverychoco.dto.RegisterRequest;
import com.deliverychoco.entity.Role;
import com.deliverychoco.entity.User;
import com.deliverychoco.repository.UserRepository;
import com.deliverychoco.security.JwtService;
import com.deliverychoco.service.AuthService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthServiceImpl(
            UserRepository userRepository,
            BCryptPasswordEncoder passwordEncoder,
            JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public String register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return "Email already exists";
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.CUSTOMER)
                .build();

        userRepository.save(user);

        return "User registered successfully";
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        System.out.println("=================================");
        System.out.println("LOGIN ATTEMPT");
        System.out.println("EMAIL: " + request.getEmail());

        User user = userRepository.findByEmail(request.getEmail())
                .orElse(null);

        System.out.println("USER FOUND: " + (user != null));

        if (user == null) {
            throw new RuntimeException("Invalid email or password");
        }

        System.out.println("DB PASSWORD: " + user.getPassword());

        boolean matches = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        System.out.println("PASSWORD MATCH: " + matches);

        if (!matches) {
            throw new RuntimeException("Invalid email or password");
        }

        String token = jwtService.generateToken(user.getEmail());

        System.out.println("TOKEN GENERATED");
        System.out.println("=================================");

        return new AuthResponse(token);
    }
}