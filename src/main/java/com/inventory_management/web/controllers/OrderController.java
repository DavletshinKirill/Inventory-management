package com.inventory_management.web.controllers;

import com.inventory_management.domain.Order;
import com.inventory_management.web.dto.OrderDTO;
import com.inventory_management.web.mappers.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/home/order/")
@RequiredArgsConstructor
public class OrderController {

    private final OrderMapper orderMapper;

    @PutMapping(value = "update")
    public OrderDTO updateOrder(@RequestBody OrderDTO orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);
//        Order savedOrder = orderService.updateOrder(order);
        return orderMapper.toDto(order);
    }

    @DeleteMapping(value = "delete/{id}")
    public void deleteOrder(@PathVariable("id") String orderUUID) {
//        orderService.deleteOrder(orderUUID);
    }
}
