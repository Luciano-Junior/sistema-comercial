package com.c9tecnologia.comercial.produto.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "product")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(unique = true, nullable = false, length = 10)
    private String code;
}
