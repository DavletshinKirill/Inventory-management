package com.inventory_management.web.controllers;


import com.inventory_management.web.dto.ProductDTO;
import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/home/product/")
@RequiredArgsConstructor
public class ProductController {


    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return null;
    }

    @PutMapping(value = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
        return null;
    }

    @DeleteMapping(value = "delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Long deleteProduct(@PathVariable("id") Long productId) {

        return productId;
    }

    @GetMapping(value = "getAllProducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ProductDTO> getProduct() {
        return null;
    }
}
