package com.inventory_management.web.controllers;

import com.inventory_management.domain.Order;
import com.inventory_management.domain.OrderStatus;
import com.inventory_management.service.interfaces.OrderService;
import com.inventory_management.web.dto.OrderDTO;
import com.inventory_management.web.mappers.OrderMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
@Tag(name = "Order Controller", description = "Order API")
public class OrderController {

    private final OrderMapper orderMapper;
    private final OrderService orderService;

    @Operation(summary = "Create Order")
    @PostMapping(value = "create")
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);
       Order savedOrder = orderService.createOrder(order);
        return orderMapper.toDto(savedOrder);
    }

    @Operation(summary = "Update Order By Status")
    @PatchMapping(value = "update/{id}")
    public OrderDTO updateOrder(@PathVariable UUID id,
                                @RequestParam OrderStatus status) {
        Order savedOrder = orderService.updateStatus(id, status);
        return orderMapper.toDto(savedOrder);
    }

    @Operation(summary = "Delete Order By Id")
    @DeleteMapping(value = "delete/{id}")
    public void deleteOrder(@PathVariable("id") UUID orderUUID) {
        orderService.deleteOrder(orderUUID);
    }

    @Operation(summary = "Get Order By Id")
    @GetMapping(value = "get/{id}")
    public OrderDTO getOrder(@PathVariable("id") UUID orderUUID) {
        Order order = orderService.getById(orderUUID);
        return orderMapper.toDto(order);
    }

    @Operation(summary = "Get Order By User Id")
    @GetMapping(value = "get/by_user")
    public List<OrderDTO> getOrders() {
        return orderMapper.toDto(orderService.getAllOrdersByUserId());
    }
}
