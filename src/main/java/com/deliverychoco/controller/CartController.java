package com.deliverychoco.controller;

import com.deliverychoco.dto.AddToCartRequest;
import com.deliverychoco.entity.Cart;
import com.deliverychoco.service.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/create/{userId}")
    public Cart createCart(
            @PathVariable Long userId) {

        return cartService.createCart(userId);
    }

    @PostMapping("/add")
    public Cart addToCart(
            @RequestBody AddToCartRequest request) {

        return cartService.addToCart(request);
    }

    @GetMapping("/{cartId}")
    public Cart getCart(
            @PathVariable Long cartId) {

        return cartService.getCart(cartId);
    }
}