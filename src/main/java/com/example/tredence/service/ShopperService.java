package com.example.tredence.service;

import com.example.tredence.dto.PersonalizedProductDto;
import com.example.tredence.dto.Shelf;
import com.example.tredence.dto.ShopperProductDto;
import com.example.tredence.entity.PersonalizedProduct;
import com.example.tredence.entity.Products;
import com.example.tredence.entity.Shoppers;
import com.example.tredence.repository.PersonalizedProductRepository;
import com.example.tredence.repository.ProductRepository;
import com.example.tredence.repository.ShopperRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopperService {

    @Autowired
    private ShopperRepository shopperRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PersonalizedProductRepository personalizedProductRepository;

    public void processPersonalizedProductList(List<ShopperProductDto> personalizedProductDto) {

        saveShelfItems(personalizedProductDto);

        }
  //  ShopperShelf - ShopperProductDto
    // ShopperShelfItem - Shelf

    @Transactional
    public void saveShelfItems(List<ShopperProductDto> shelves) {
        List<PersonalizedProduct> shelfItems = new ArrayList<>();

        for (ShopperProductDto shelf : shelves) {
            String shopperId = shelf.getShopperId();
            for (Shelf shelfItem : shelf.getShelf()) {
                PersonalizedProduct item = new PersonalizedProduct();
                item.setRelevancyScore(shelfItem.getRelevancyScore());

                // Assuming Shoppers and Products are JPA entities
                Shoppers shoppers = shopperRepository.findByShopperId(shopperId)
                        .orElseThrow(() -> new RuntimeException("Shopper not found: " + shopperId));
                Products products = productRepository.findByProductId(shelfItem.getProductId())
                        .orElseThrow(() -> new RuntimeException("Product not found: " + shelfItem.getProductId()));

                item.setShoppers(shoppers);
                item.setProducts(products);

                shelfItems.add(item);
            }
        }

        personalizedProductRepository.saveAll(shelfItems);
    }

    public void saveShopperMetadata(List<Shoppers> shopper) {
        shopperRepository.saveAll(shopper);
    }






    public Page<PersonalizedProduct> getPersonalizedProducts(String category, String brand, String productId,
                                                             String sortBy, String sortOrder, Pageable pageable) {
        return personalizedProductRepository.findAll
                (category, brand, productId, sortBy , pageable);
    }


}

