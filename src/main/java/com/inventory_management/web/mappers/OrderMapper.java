package com.inventory_management.web.mappers;

import com.inventory_management.domain.Order;
import com.inventory_management.web.dto.OrderDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface OrderMapper {

    OrderDTO toDto(Order order);

    Order toEntity(OrderDTO orderDTO);

    List<OrderDTO> toDto(List<Order> orders);
}
