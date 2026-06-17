package com.deliverychoco.service.impl;

import com.deliverychoco.dto.AddToCartRequest;
import com.deliverychoco.entity.*;
import com.deliverychoco.repository.*;
import com.deliverychoco.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;
    private final MenuItemRepository menuItemRepository;

    public CartServiceImpl(
            CartRepository cartRepository,
            CartItemRepository cartItemRepository,
            UserRepository userRepository,
            MenuItemRepository menuItemRepository) {

        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.userRepository = userRepository;
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public Cart createCart(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Cart cart = Cart.builder()
                .user(user)
                .build();

        return cartRepository.save(cart);
    }

    @Override
    public Cart addToCart(AddToCartRequest request) {

        Cart cart = cartRepository.findById(request.getCartId())
                .orElseThrow(() ->
                        new RuntimeException("Cart not found"));

        MenuItem menuItem =
                menuItemRepository.findById(request.getMenuItemId())
                        .orElseThrow(() ->
                                new RuntimeException("Menu item not found"));

        CartItem cartItem = CartItem.builder()
                .cart(cart)
                .menuItem(menuItem)
                .quantity(request.getQuantity())
                .build();

        cartItemRepository.save(cartItem);

        return cartRepository.findById(cart.getId()).get();
    }

    @Override
    public Cart getCart(Long cartId) {

        return cartRepository.findById(cartId)
                .orElseThrow(() ->
                        new RuntimeException("Cart not found"));
    }
}