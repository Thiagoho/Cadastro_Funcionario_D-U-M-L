package com.example.usuariovalidator.validation;


/* 
 * O método initialize() captura o valor da idade mínima configurada na annotation.
 * O método isValid() compara a idade informada com o valor mínimo.
 * */


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IdadeMinimaValidator implements ConstraintValidator<IdadeMinima, Integer> {

    private int idadeMinima;

    @Override
    public void initialize(IdadeMinima constraintAnnotation) {
        this.idadeMinima = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Integer idade, ConstraintValidatorContext context) {
        if (idade == null) return true;
        return idade >= idadeMinima;
    }
}