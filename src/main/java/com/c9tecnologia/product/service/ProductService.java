package com.c9tecnologia.product.service;

import com.c9tecnologia.product.dto.ProductOutputDTO;
import com.c9tecnologia.product.model.Product;
import com.c9tecnologia.product.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductService(ProductRepository productRepository, ModelMapper modelMapper){
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public List<ProductOutputDTO> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product, ProductOutputDTO.class))
                .toList();
    }
}
