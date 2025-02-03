package com.c9tecnologia.comercial.cliente.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CnpjCpfValidator implements ConstraintValidator<CnpjCpf, String> {

    // Regex para validar CPF e CNPJ
    private static final String REGEX_CPF = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{11}"; // CPF com ou sem formatação
    private static final String REGEX_CNPJ = "\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}|\\d{14}"; // CNPJ com ou sem formatação

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Permite valores nulos ou vazios (use @NotBlank se precisar obrigar preenchimento)
        if (value == null || value.isEmpty()) {
            return true;
        }

        // Verifica se o valor corresponde ao padrão de CPF ou CNPJ
        return value.matches(REGEX_CPF) || value.matches(REGEX_CNPJ);
    }
}
