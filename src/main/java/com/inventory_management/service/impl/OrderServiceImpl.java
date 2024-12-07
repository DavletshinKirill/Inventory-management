package com.inventory_management.service.impl;

import com.inventory_management.domain.Order;
import com.inventory_management.domain.OrderStatus;
import com.inventory_management.domain.Product;
import com.inventory_management.domain.exception.ResourceNotFoundException;
import com.inventory_management.repositories.OrderRepository;
import com.inventory_management.service.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public Order createOrder(Order order, UUID userId) {
        order.setUserId(userId);
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public Order updateStatus(UUID id, OrderStatus status) {
        Order order = getById(id);
        order.setStatus(status);
        return orderRepository.save(order);
    }

    @Override
    @Transactional(readOnly = true)
    public Order getById(UUID id) {
        return orderRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Order not found")
        );
    }

    @Override
    public List<Order> getAllOrdersByUserId(UUID userId, int offset, int limit) {
        Pageable pageable = PageRequest.of(offset, limit);
        Page<Order> orders = orderRepository.findByUserId(userId, pageable);
        return orders.hasContent() ? new ArrayList<>(orders.getContent()) : Collections.emptyList();
    }

    @Override
    @Transactional
    public void deleteOrder(UUID id) {
        Order order = getById(id);
        order.setProducts(List.of());
        orderRepository.delete(order);
    }
}
