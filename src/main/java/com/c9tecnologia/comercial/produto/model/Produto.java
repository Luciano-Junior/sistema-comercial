package com.c9tecnologia.comercial.produto.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "produto")

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer categoria_id;

    @Column(nullable = false, length = 30)
    private String nome;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double preco_custo;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double preco_venda;

    @Column(unique = true, nullable = true, length = 50)
    private String codigo_barras;

    private Integer estoque;

    private Integer estoque_minimo;

    private Integer unidade_medida_id;

    @Column(nullable = true, length = 100)
    private String fabricante;

    @Column(nullable = true, length = 100)
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
