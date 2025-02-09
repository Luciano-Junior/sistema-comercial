package com.c9tecnologia.comercial.produto.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ProdutoInputDTO {
    //@NotNull(message = "O Campo categoria é obrigatório!")
    private Long categoriaId;

    @NotBlank(message = "O Campo nome é obrigatório!")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "O Campo descrição é obrigatório!")
    @Size(max = 255, message = "A descrição pode ter no máximo 255 caracteres")
    private String descricao;

    @NotNull(message = "O Campo preço de custo é obrigatório!")
    @Positive(message = "O valor do preço deve ser positivo")
    private BigDecimal preco_custo;

    @NotNull(message = "O Campo preço de venda é obrigatório!")
    @Positive(message = "O valor do preço de venda deve ser positivo")
    private BigDecimal preco_venda;

    private String codigo_barras;

    @Min(value = 0, message = "O Estoque não pode ser negativa")
    private Integer estoque;
    @Min(value = 0, message = "A Estoque Minimo não pode ser negativa")
    private Integer estoque_minimo;

    @NotNull(message = "O Campo preço de venda é obrigatório!")
    private Long unidadeMedidaId;

    private String fabricante;
    private String marca;

    private Date data_cadastro;

    private Date data_atualizacao;

    private String tags;
}
