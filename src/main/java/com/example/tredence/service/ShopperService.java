package com.example.tredence.service;

import com.example.tredence.entity.PersonalizedProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ShopperService {

/*    @Autowired
    private ShopperRepository shopperRepository;*/

    public void processPersonalizedProductList(PersonalizedProduct productListDTO) {
        // Implement logic to parse and persist personalized product list
        // Utilize streams and lambda expressions for concise code
        // Example: productListDTO.getProducts().stream().forEach(product -> saveProduct(product));
    }

    // Other service methods...

/*
        public Page<ProductDTO> getPersonalizedProductList(String shopperId, String category, String brand,
                                                           String productId, int limit, int page,
                                                           String sortBy, String sortOrder) {
            Sort.Direction sortDirection = sortOrder.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
            Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, sortBy));

            Specification<Product> spec = Specification.where(ProductSpecifications.filterByShopperId(shopperId));
            if (category != null) {
                spec = spec.and(ProductSpecifications.filterByCategory(category));
            }
            if (brand != null) {
                spec = spec.and(ProductSpecifications.filterByBrand(brand));
            }
            if (productId != null) {
                spec = spec.and(ProductSpecifications.filterByProductId(productId));
            }

            Page<Product> productPage = productRepository.findAll(spec, pageable);
            return productPage.map(ProductDTO::fromEntity);
        }
    }*/

}

