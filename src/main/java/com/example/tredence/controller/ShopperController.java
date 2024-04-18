package com.example.tredence.controller;

import com.example.tredence.entity.PersonalizedProduct;
import com.example.tredence.repository.ProductRepository;
import com.example.tredence.service.ShopperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShopperController {

    @Autowired
    private ShopperService shopperService;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/shopper/personalized-products")
    public ResponseEntity<String> receivePersonalizedProducts(@RequestBody PersonalizedProduct productListDTO) {
        // Call service method to process personalized product list
        shopperService.processPersonalizedProductList(productListDTO);
        return ResponseEntity.ok("Personalized product list received and processed successfully.");
    }

    @GetMapping("/")
    public void getProduct()
    {
        System.out.println( productRepository.findAll());
    }


/*
    @GetMapping("/shopper/{shopperId}/personalized-products")
    public ResponseEntity<  List<ProductDto>> getPersonalizedProductList(
            @PathVariable Long shopperId,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) Long productId,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Integer minRating,
            @RequestParam(defaultValue = "relevancyScore") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        List<ProductDTO> products = shopperService.getPersonalizedProductList(
                shopperId, category, brand, productId, limit,
                minPrice, maxPrice, minRating, sortBy, sortOrder, page, size);

        return ResponseEntity.ok(products);
    }
*/

    // Other endpoints...
}