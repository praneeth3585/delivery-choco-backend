package com.deliverychoco.controller;

import com.deliverychoco.dto.CreateOrderRequest;
import com.deliverychoco.entity.Order;
import com.deliverychoco.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(
            OrderService orderService) {

        this.orderService = orderService;
    }

    @PostMapping
    public Order placeOrder(
            @RequestBody CreateOrderRequest request) {

        return orderService.placeOrder(request);
    }

    @GetMapping("/{id}")
    public Order getOrder(
            @PathVariable Long id) {

        return orderService.getOrder(id);
    }
    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUser(
            @PathVariable Long userId) {

        return orderService.getOrdersByUser(userId);
    }
}