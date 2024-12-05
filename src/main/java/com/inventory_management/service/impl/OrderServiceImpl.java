package com.inventory_management.service.impl;

import com.inventory_management.domain.Order;
import com.inventory_management.domain.OrderStatus;
import com.inventory_management.service.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    @Override
    public Order createOrder(Order order) {
        return null;
    }

    @Override
    public Order updateStatus(UUID id, OrderStatus status) {
        return null;
    }

    @Override
    public Order getById(UUID id) {
        return null;
    }

    @Override
    public List<Order> getAllOrdersByUserId() {
        return List.of();
    }

    @Override
    public void deleteOrder(UUID id) {

    }
}
