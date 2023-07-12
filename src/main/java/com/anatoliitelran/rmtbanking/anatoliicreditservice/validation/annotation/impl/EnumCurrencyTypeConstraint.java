package com.anatoliitelran.rmtbanking.anatoliicreditservice.validation.annotation.impl;


import com.anatoliitelran.rmtbanking.anatoliicreditservice.entity.enums.CurrencyType;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.validation.annotation.EnumCurrencyType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumCurrencyTypeConstraint implements ConstraintValidator<EnumCurrencyType, String> {


    @Override
    public void initialize(EnumCurrencyType constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String currencyType, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;
        if (currencyType == null) {
            result = true;
        } else
            try {
                CurrencyType.valueOf(currencyType.toUpperCase());
                result = true;
            } catch (RuntimeException e) {
                result = false;
            }
        return result;
    }
}
