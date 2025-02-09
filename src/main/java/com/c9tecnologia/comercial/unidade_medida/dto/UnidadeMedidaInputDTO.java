package com.c9tecnologia.comercial.unidade_medida.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnidadeMedidaInputDTO {
    @NotBlank(message = "O Campo nome é obrigatório!")
    private String nome;
    @NotBlank(message = "O Campo sigla é obrigatório!")
    @Size(min = 2, max = 3)
    private String sigla;
}
