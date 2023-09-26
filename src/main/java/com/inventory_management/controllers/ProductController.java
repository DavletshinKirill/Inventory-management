package com.inventory_management.controllers;

import com.inventory_management.dto.ProductDTO;
import com.inventory_management.services.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/home/product/")
@Api("Контроллер для товаров")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.creteProduct(productDTO);
    }

    @PutMapping(value = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
        return productService.updateProduct(productDTO);
    }

    @DeleteMapping(value="delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Long deleteProduct(@PathVariable("id")Long productId)
    {
        productService.deleteProduct(productId);
        return productId;
    }

    @GetMapping(value = "getAllProducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ProductDTO> getProduct() {
        return productService.getAllProducts();
    }
}
