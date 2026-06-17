package com.deliverychoco.service;

import com.deliverychoco.dto.CreateOrderRequest;
import com.deliverychoco.entity.Order;

import java.util.List;

public interface OrderService {

    Order placeOrder(CreateOrderRequest request);

    Order getOrder(Long orderId);

    List<Order> getOrdersByUser(Long userId);
}