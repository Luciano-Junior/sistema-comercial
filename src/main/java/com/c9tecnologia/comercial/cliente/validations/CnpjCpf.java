package com.c9tecnologia.comercial.cliente.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CnpjCpfValidator.class) // Aponta para o validador que será implementado
@Target({ElementType.FIELD, ElementType.PARAMETER}) // Pode ser usado em campos e parâmetros de métodos
@Retention(RetentionPolicy.RUNTIME) // A anotação estará disponível em tempo de execução
public @interface CnpjCpf {

    // Mensagem padrão em caso de erro de validação
    String message() default "CNPJ/CPF inválido";

    // Permite agrupar validações
    Class<?>[] groups() default {};

    // Define payloads adicionais (normalmente não usado, mas necessário pelo contrato da Bean Validation)
    Class<? extends Payload>[] payload() default {};
}
