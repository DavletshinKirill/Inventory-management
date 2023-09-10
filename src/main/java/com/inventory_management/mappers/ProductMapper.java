package com.inventory_management.mappers;

import com.inventory_management.db.entity.Order;
import com.inventory_management.db.entity.Product;
import com.inventory_management.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper( ProductMapper.class );

    ProductDTO toDto(Product order);

    Product toEntity(ProductDTO orderDTO);

}
