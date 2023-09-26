package com.inventory_management.services;


import com.inventory_management.db.entity.Order;
import com.inventory_management.db.repositories.OrderRepo;
import com.inventory_management.dto.OrderDTO;
import com.inventory_management.mappers.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;


    public OrderDTO updateOrder(OrderDTO orderDTO) {
        Order order = OrderMapper.INSTANCE.toEntity(orderDTO);
        return OrderMapper.INSTANCE.toDto(orderRepo.save(order));
    }

    public void deleteOrder(Long orderId) {
        orderRepo.deleteById(orderId);
    }
}
