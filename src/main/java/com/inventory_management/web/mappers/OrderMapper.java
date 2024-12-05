package com.inventory_management.web.mappers;

import com.inventory_management.domain.Order;
import com.inventory_management.web.dto.OrderDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDTO toDto(Order order);

    Order toEntity(OrderDTO orderDTO);
}
