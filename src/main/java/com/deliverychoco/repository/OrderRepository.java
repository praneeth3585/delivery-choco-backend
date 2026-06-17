package com.deliverychoco.repository;

import com.deliverychoco.entity.Order;
import com.deliverychoco.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository
        extends JpaRepository<Order, Long> {

    List<Order> findByUser(User user);
}