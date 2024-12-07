package com.inventory_management.service.impl;

import com.inventory_management.domain.Product;
import com.inventory_management.domain.ProductImage;
import com.inventory_management.domain.exception.ResourceNotFoundException;
import com.inventory_management.repositories.ProductRepository;
import com.inventory_management.service.interfaces.ProductImageService;
import com.inventory_management.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductImageService productImageService;

    @Override
    @Transactional
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Product updatePrice(UUID productUUID, BigDecimal price) {
        Product product = getProduct(productUUID);
        product.setPrice(price);
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Product updateStockQuantity(UUID productUUID, int stockQuantity) {
        Product product = getProduct(productUUID);
        product.setStockQuantity(stockQuantity);
        return productRepository.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Product getProduct(UUID productUUID) {
        return productRepository.findById(productUUID).orElseThrow(
                () ->new ResourceNotFoundException("Product not found")
        );
    }

    @Override
    @Transactional
    public void deleteProduct(UUID productUUID) {
        productRepository.deleteById(productUUID);
    }

    @Override
    public List<Product> getProducts(int offset, int limit) {
        Pageable pageable = PageRequest.of(offset, limit);
        Page<Product> products = productRepository.findAll(pageable);
        return products.hasContent() ? new ArrayList<>(products.getContent()) : Collections.emptyList();
    }

    @Override
    @Transactional
    public Product uploadImage(UUID productUUID, ProductImage productImage) {
        String imageName = productImageService.upload(productImage);
        Product product = getProduct(productUUID);
        product.setPhoto(imageName);
        return productRepository.save(product);
    }
}
