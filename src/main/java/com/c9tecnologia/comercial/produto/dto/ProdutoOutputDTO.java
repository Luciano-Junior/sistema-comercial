package com.c9tecnologia.comercial.produto.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoOutputDTO {
    private Integer categoria_id;
    private String nome;
    private String descricao;
    private Double preco_custo;
    private Double preco_venda;
    private String estoque;
    private String estoque_minimo;
    private String unidade_medida_id;
    private String fabricante;
    private String marca;
    private Date data_cadastro;
    private Date data_atualizacao;
    private String tags;
}
