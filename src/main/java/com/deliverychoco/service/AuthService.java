package com.deliverychoco.service;

import com.deliverychoco.dto.AuthResponse;
import com.deliverychoco.dto.LoginRequest;
import com.deliverychoco.dto.RegisterRequest;

public interface AuthService {

    String register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}