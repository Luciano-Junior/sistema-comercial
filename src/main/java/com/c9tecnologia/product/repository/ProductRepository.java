package com.c9tecnologia.product.repository;

import com.c9tecnologia.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
