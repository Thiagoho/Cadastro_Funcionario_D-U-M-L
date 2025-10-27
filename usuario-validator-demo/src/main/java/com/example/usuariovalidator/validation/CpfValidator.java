/*
 * A annotation @Cpf usa @Constraint para ligar-se ao validador CpfValidator.
 * O validador usa expressão regular para confirmar o formato correto.
 * Retorna true se o campo estiver vazio (para permitir uso
 * com @NotBlank separado) ou se o formato for válido.
 */

package com.example.usuariovalidator.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CpfValidator implements ConstraintValidator<Cpf, String> {
    private static final String CPF_REGEX = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) return true;
        return value.matches(CPF_REGEX);
    }
}