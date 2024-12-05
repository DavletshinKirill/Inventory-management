package com.inventory_management.service.impl;

import com.inventory_management.domain.Product;
import com.inventory_management.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public Product updatePrice(UUID productUUID, BigDecimal price) {
        return null;
    }

    @Override
    public Product updateStockQuantity(UUID productUUID, BigDecimal price) {
        return null;
    }

    @Override
    public Product getProduct(UUID productUUID) {
        return null;
    }

    @Override
    public void deleteProduct(UUID productUUID) {

    }

    @Override
    public List<Product> getProducts(int offset, int limit) {
        return List.of();
    }
}
