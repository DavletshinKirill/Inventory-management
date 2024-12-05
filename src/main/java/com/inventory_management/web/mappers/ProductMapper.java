package com.inventory_management.web.mappers;

import com.inventory_management.domain.Product;
import com.inventory_management.web.dto.ProductDTO;
import org.mapstruct.Mapper;

import java.util.ArrayList;


@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDto(Product order);

    Product toEntity(ProductDTO orderDTO);

    ArrayList<ProductDTO> listToDTO(ArrayList<Product> listOfPosts);

}
