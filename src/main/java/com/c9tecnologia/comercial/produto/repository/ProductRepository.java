package com.c9tecnologia.comercial.produto.repository;

import com.c9tecnologia.comercial.produto.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
