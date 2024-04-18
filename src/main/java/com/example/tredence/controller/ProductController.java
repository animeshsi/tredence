package com.example.tredence.controller;


import com.example.tredence.entity.Products;
import com.example.tredence.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/product-metadata")
    public ResponseEntity<?> saveProductMetadata(@Valid @RequestBody List<Products> products) {
        productService.saveProductMetadata(products);
        return ResponseEntity.ok().build();
    }
}
