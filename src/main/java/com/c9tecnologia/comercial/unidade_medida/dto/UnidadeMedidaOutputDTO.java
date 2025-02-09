package com.c9tecnologia.comercial.unidade_medida.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnidadeMedidaOutputDTO {
    private Long id;
    private String nome;
    private String sigla;
}
