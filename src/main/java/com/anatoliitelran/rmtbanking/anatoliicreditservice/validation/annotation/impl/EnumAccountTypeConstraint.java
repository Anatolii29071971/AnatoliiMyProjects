package com.anatoliitelran.rmtbanking.anatoliicreditservice.validation.annotation.impl;


import com.anatoliitelran.rmtbanking.anatoliicreditservice.entity.enums.AccountType;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.validation.annotation.EnumAccountTypeOrNull;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumAccountTypeConstraint implements ConstraintValidator<EnumAccountTypeOrNull, String> {
    @Override
    public void initialize(EnumAccountTypeOrNull constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String type, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;
        if (type == null) {
            result = true;
        } else
            try {
                AccountType.valueOf(type);
                result = true;
            } catch (RuntimeException e) {
                result = false;
            }
        return result;
    }
}
