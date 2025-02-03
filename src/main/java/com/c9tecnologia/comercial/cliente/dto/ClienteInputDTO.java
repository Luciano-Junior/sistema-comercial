package com.c9tecnologia.comercial.cliente.dto;

import com.c9tecnologia.comercial.cliente.validations.CnpjCpf;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClienteInputDTO {
    private String situacao;
    @NotBlank(message = "O campo pessoa é obrigatório")
    @NotBlank(message = "O campo pessoa é obrigatório")
    private String pessoa;

    @NotBlank(message = "O campo CPF/CNPJ é obrigatório")
    @NotBlank(message = "O campo CPF/CNPJ é obrigatório")
    @CnpjCpf(message = "Formato do CPF/CNPJ inválido!")
    private String cnpjcpf;

    private String rg;
    private String razao_social;
    private LocalDate data_nascimento;

    @NotBlank(message = "O nome fantasia é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    @NotBlank(message = "O nome fantasia é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome_fantasia;

    private String sexo;
    private String estad_civil;
    private String cep;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String celular;

    @Email(message = "O e-mail deve ser válido")
    @Email(message = "O e-mail deve ser válido")
    private String email;

    private String obs;
    private String tipo_cadastro;
    private String categoria;
    private Integer criado_por;
    private Integer atualizado_por;
}
