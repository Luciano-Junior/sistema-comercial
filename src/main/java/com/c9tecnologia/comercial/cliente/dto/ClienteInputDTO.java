package com.c9tecnologia.comercial.cliente.dto;

import com.c9tecnologia.comercial.cliente.validations.CnpjCpf;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

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
    private String razaoSocial;
    private LocalDate dataNascimento;

    @NotBlank(message = "O nome fantasia é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    @NotBlank(message = "O nome fantasia é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nomeFantasia;

    private String sexo;
    private String estadoCivil;
    private String cep;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String ibge;
    private String estado;
    private String celular;

    @Email(message = "O e-mail deve ser válido")
    @Email(message = "O e-mail deve ser válido")
    private String email;

    private String obs;
    private String tipoCadastro;
    private String profissao;
    private String categoria;
    private String listaPreco;
    private String condicaoPagamento;
    private String contaBancaria;
    private Double limiteCredito;
    private Boolean limiteUltrapassar;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private LocalDate dataCadastro;
    private LocalTime horaCadastro;
    private String horario;
    @Size(max = 3)
    private String deveReceberSms;
    @Size(max = 3)
    private String deveReceberTorpedoVoz;
    private String criadoPor;
    private String atualizadoPor;
}
