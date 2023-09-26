package com.inventory_management.controllers;

import com.inventory_management.dto.OrderDTO;
import com.inventory_management.services.OrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/home/order/")
@Api("Контроллер для заказов")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PutMapping(value = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderDTO updateOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.updateOrder(orderDTO);
    }

    @DeleteMapping(value="delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOrder(@PathVariable("id")Long orderId)
    {
        orderService.deleteOrder(orderId);
    }
}
