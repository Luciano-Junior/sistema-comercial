package com.c9tecnologia.product.controller;

import com.c9tecnologia.product.dto.ProductOutputDTO;
import com.c9tecnologia.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    ProductService productService;

    public ProductController (ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductOutputDTO>> getAllProducts(){
        List<ProductOutputDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

}
