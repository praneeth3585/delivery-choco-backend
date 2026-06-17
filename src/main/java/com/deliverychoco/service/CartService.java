package com.deliverychoco.service;

import com.deliverychoco.dto.AddToCartRequest;
import com.deliverychoco.entity.Cart;

public interface CartService {

    Cart createCart(Long userId);

    Cart addToCart(AddToCartRequest request);

    Cart getCart(Long cartId);
}