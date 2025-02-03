package com.c9tecnologia.comercial.produto.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Entity
@Data
@Table(name = "produto")

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer categoria_id;

    @Column(nullable = false, length = 30)
    private String nome;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double preco_custo;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double preco_venda;

    @Column(unique = true, nullable = false, length = 50)
    private String codigo_barras;

    private Integer estoque;

    private Integer estoque_minimo;

    private Integer unidade_medida_id;

    @Column(nullable = false, precision = 10, scale = 3)
    private Double peso;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double largura;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double altura;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double comprimento;

    @Column(nullable = false, length = 100)
    private String fabricante;

    @Column(nullable = false, length = 100)
    private String marca;

    @Temporal(TemporalType.DATE)
    private Date data_cadastro;

    @PrePersist
    protected void onCreate() {
        this.data_cadastro = new Date();
    }

    @Column(nullable = true)
    private Date data_atualizacao;

    @ColumnDefault("true")
    private Boolean ativo;

    @Column(nullable = true)
    private String tags;
}
