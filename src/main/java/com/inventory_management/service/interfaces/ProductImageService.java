package com.inventory_management.service.interfaces;

import com.inventory_management.domain.ProductImage;

import java.io.InputStream;

public interface ProductImageService {
    String upload(ProductImage productImage);
    InputStream download(String imagePath);

    void deleteImage(String imagePath);
}
