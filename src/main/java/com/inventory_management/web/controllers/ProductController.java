package com.inventory_management.web.controllers;


import com.inventory_management.domain.Product;
import com.inventory_management.domain.ProductImage;
import com.inventory_management.service.interfaces.ProductImageService;
import com.inventory_management.service.interfaces.ProductService;
import com.inventory_management.web.dto.ProductDTO;
import com.inventory_management.web.mappers.ProductMapper;
import com.inventory_management.web.validators.OnCreate;
import com.inventory_management.web.validators.OnUpdate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
@Tag(name = "Product Controller", description = "Product API")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;
    private final ProductImageService productImageService;

    @Operation(summary = "Create Product")
    @PostMapping(value = "/create")
    public ProductDTO createProduct(@Validated(OnCreate.class) @RequestBody ProductDTO productDTO) {

        Product product = productMapper.toEntity(productDTO);
        Product createdProduct = productService.createProduct(product);
        return productMapper.toDto(createdProduct);
    }

    @Operation(summary = "Update Product")
    @PutMapping(value = "/update")
    public ProductDTO update(@Validated(OnUpdate.class) @RequestBody ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        Product createdProduct = productService.updateProduct(product);
        return productMapper.toDto(createdProduct);
    }

    @Operation(summary = "Update Price Product")
    @PatchMapping(value = "/update/price/{id}")
    public ProductDTO updatePrice(@PathVariable UUID id,
                                  @RequestParam(defaultValue = "20000") BigDecimal price) {
        
        Product createdProduct = productService.updatePrice(id, price);
        return productMapper.toDto(createdProduct);
    }

    @Operation(summary = "Update Stock Quantity Product")
    @PatchMapping(value = "/update/quantity/{id}")
    public ProductDTO updateStockQuantity(@PathVariable UUID id,
                                    @RequestParam(defaultValue = "5") int stockQuantity) {
        Product createdProduct = productService.updateStockQuantity(id, stockQuantity);
        return productMapper.toDto(createdProduct);
    }

    @Operation(summary = "Delete Product")
    @DeleteMapping(value = "/delete/{id}")
    public void deleteProduct(@PathVariable("id") UUID productId) {
        productService.deleteProduct(productId);
    }

    @Operation(summary = "Get Product")
    @GetMapping(value = "/get/{id}")
    public ProductDTO getProduct(@PathVariable("id") UUID productId) {
        Product product = productService.getProduct(productId);
        return productMapper.toDto(product);
    }

    @Operation(summary = "Get Products")
    @GetMapping(value = "/getProducts")
    public List<ProductDTO> getProducts(
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "5") int limit
    ) {
        List<Product> products = productService.getProducts(offset, limit);
        return productMapper.listToDTO(products);
    }


    @Operation(summary = "Download Image")
    @GetMapping("/download/image/{path}")
    @SneakyThrows
    public ResponseEntity<ByteArrayResource> downloadImage(@PathVariable String path) {
        byte[] data = productImageService.download(path).readAllBytes();
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + path + "\"")
                .body(resource);
    }

    @Operation(summary = "Upload Image")
    @PostMapping("/upload/image/{productId}")
    public ProductDTO uploadImage(@PathVariable UUID productId, ProductImage product) {
        Product productReturned = productService.uploadImage(productId, product);
        return productMapper.toDto(productReturned);
    }
}
