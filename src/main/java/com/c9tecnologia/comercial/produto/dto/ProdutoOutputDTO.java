package com.c9tecnologia.comercial.produto.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ProdutoOutputDTO {
    //private String categoriaNome;
    private String nome;
    private String descricao;
    private Double preco_custo;
    private Double preco_venda;
    private Integer estoque;
    private Integer estoque_minimo;
    private String unidadeMedidaNome;
    private String fabricante;
    private String marca;
    private Date data_cadastro;
    private Date data_atualizacao;
    private String tags;
}
