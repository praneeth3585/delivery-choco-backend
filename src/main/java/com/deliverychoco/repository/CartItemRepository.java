package com.deliverychoco.repository;

import com.deliverychoco.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository
        extends JpaRepository<CartItem, Long> {
}