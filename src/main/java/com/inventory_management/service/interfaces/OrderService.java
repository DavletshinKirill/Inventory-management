package com.inventory_management.service.interfaces;

import com.inventory_management.domain.Order;
import com.inventory_management.domain.OrderStatus;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    Order createOrder(Order order, UUID userId);
    Order updateStatus(UUID id, OrderStatus status);
    Order getById(UUID id);
    List<Order> getAllOrdersByUserId(UUID userId, int offset, int limit);
    void deleteOrder(UUID id);
}
