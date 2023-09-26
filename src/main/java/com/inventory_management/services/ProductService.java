package com.inventory_management.services;

import com.inventory_management.db.entity.Product;
import com.inventory_management.db.repositories.ProductRepo;

import com.inventory_management.dto.ProductDTO;
import com.inventory_management.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public ArrayList<ProductDTO> getAllProducts() {
        ArrayList<Product> products = (ArrayList<Product>) productRepo.findAll();
        return ProductMapper.INSTANCE.listToDTO(products);
    }

    public ProductDTO creteProduct(ProductDTO productDTO) {
        Product product = ProductMapper.INSTANCE.toEntity(productDTO);
        return ProductMapper.INSTANCE.toDto(productRepo.save(product));
    }

    public ProductDTO updateProduct(ProductDTO productDTO) {
        Product product = ProductMapper.INSTANCE.toEntity(productDTO);
        return ProductMapper.INSTANCE.toDto(productRepo.save(product));
    }

    public void deleteProduct(Long productId) {
        productRepo.deleteById(productId);
    }
}
