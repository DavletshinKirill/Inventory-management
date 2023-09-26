package com.inventory_management.mappers;

import com.inventory_management.db.entity.Product;

import com.inventory_management.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;


@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper( ProductMapper.class );

    ProductDTO toDto(Product order);

    Product toEntity(ProductDTO orderDTO);

    ArrayList<ProductDTO> listToDTO(ArrayList<Product> listOfPosts);

}
