package com.inventory_management.web.mappers;

import com.inventory_management.domain.Product;
import com.inventory_management.web.dto.ProductDTO;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDto(Product order);

    Product toEntity(ProductDTO orderDTO);

    List<ProductDTO> listToDTO(List<Product> listOfPosts);

}
