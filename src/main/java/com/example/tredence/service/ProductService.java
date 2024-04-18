package com.example.tredence.service;



import com.example.tredence.entity.Products;
import com.example.tredence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    @Autowired
    ProductRepository productRepository;
    public void saveProductMetadata(List<Products> products) {
        productRepository.saveAll(products);
    }
}
