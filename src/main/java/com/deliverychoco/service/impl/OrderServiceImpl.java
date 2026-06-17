package com.deliverychoco.service.impl;

import com.deliverychoco.dto.CreateOrderRequest;
import com.deliverychoco.entity.*;
import com.deliverychoco.repository.CartRepository;
import com.deliverychoco.repository.OrderItemRepository;
import com.deliverychoco.repository.OrderRepository;
import com.deliverychoco.repository.UserRepository;
import com.deliverychoco.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(
            CartRepository cartRepository,
            OrderRepository orderRepository,
            OrderItemRepository orderItemRepository,
            UserRepository userRepository) {

        this.cartRepository = cartRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Order placeOrder(CreateOrderRequest request) {

        Cart cart = cartRepository.findById(request.getCartId())
                .orElseThrow(() ->
                        new RuntimeException("Cart not found"));

        Order order = new Order();
        order.setUser(cart.getUser());
        order.setStatus(OrderStatus.PENDING);

        double total = 0.0;

        for (CartItem cartItem : cart.getItems()) {
            total += cartItem.getQuantity()
                    * cartItem.getMenuItem().getPrice();
        }

        order.setTotalAmount(total);

        Order savedOrder = orderRepository.save(order);

        List<OrderItem> orderItems = new ArrayList<>();

        for (CartItem cartItem : cart.getItems()) {

            OrderItem orderItem = OrderItem.builder()
                    .order(savedOrder)
                    .menuItem(cartItem.getMenuItem())
                    .quantity(cartItem.getQuantity())
                    .price(cartItem.getMenuItem().getPrice())
                    .build();

            orderItems.add(orderItem);
        }

        orderItemRepository.saveAll(orderItems);

        savedOrder.setItems(orderItems);

        return orderRepository.save(savedOrder);
    }

    @Override
    public Order getOrder(Long orderId) {

        return orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new RuntimeException("Order not found"));
    }

    @Override
    public List<Order> getOrdersByUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        return orderRepository.findByUser(user);
    }
}