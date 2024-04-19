# tredence


use these queries to run the application -
CREATE TABLE personalized_product (
    id bigint AUTO_INCREMENT PRIMARY KEY,
    shopper_id bigint NOT NULL,
    product_id bigint NOT NULL,
    relevancy_score DECIMAL(5, 2),
    CONSTRAINT fk_shopper FOREIGN KEY (shopper_id) REFERENCES shoppers(id),
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES products(id)
);


CREATE TABLE `shoppers` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `shopper_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `products` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
