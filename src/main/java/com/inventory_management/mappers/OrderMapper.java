package com.inventory_management.mappers;

import com.inventory_management.db.entity.Order;
import com.inventory_management.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper( OrderMapper.class );

    OrderDTO toDto(Order order);

    Order toEntity(OrderDTO orderDTO);
}
