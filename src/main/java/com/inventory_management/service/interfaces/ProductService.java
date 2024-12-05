package com.inventory_management.service.interfaces;

import com.inventory_management.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Product product);
    Product updatePrice(UUID productUUID, BigDecimal price);
    Product updateStockQuantity(UUID productUUID, BigDecimal price);
    Product getProduct(UUID productUUID);
    void deleteProduct(UUID productUUID);
    List<Product> getProducts(int offset, int limit);
}
