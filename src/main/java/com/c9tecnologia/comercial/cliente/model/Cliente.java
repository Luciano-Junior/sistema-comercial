package com.c9tecnologia.comercial.cliente.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String situacao;
    private String pessoa;

    @Column(unique = true, nullable = false, length = 25)
    private String cnpjcpf;
    private String rg;
    private String razao_social;
    private LocalDate data_nascimento;

    @Column(nullable = false, length = 100)
    private String nome_fantasia;
    private String sexo;
    private String estado_civil;
    private String cep;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String celular;

    @Column(unique = true, length = 100)
    private String email;
    private String obs;
    private String tipo_cadastro;
    private String categoria_id;

    private Integer criado_por;
    private Integer atualizado_por;
}
