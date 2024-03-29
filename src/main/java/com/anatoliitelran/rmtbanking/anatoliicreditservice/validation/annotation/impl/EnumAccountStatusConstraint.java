package com.anatoliitelran.rmtbanking.anatoliicreditservice.validation.annotation.impl;


import com.anatoliitelran.rmtbanking.anatoliicreditservice.entity.enums.AccountStatus;
import com.anatoliitelran.rmtbanking.anatoliicreditservice.validation.annotation.EnumAccountStatusOrNull;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumAccountStatusConstraint implements ConstraintValidator<EnumAccountStatusOrNull, String> {

    @Override
    public void initialize(EnumAccountStatusOrNull constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String status, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;
        if (status == null) {
            result = true;
        } else
            try {
                AccountStatus.valueOf(status);
                result = true;
            } catch (RuntimeException e) {
                result = false;
            }
        return result;

//        return Optional.ofNullable(status)
//                .filter(s -> !s.isBlank())
//                .map(s -> {
//                    AccountStatus.valueOf(s);
//                    return true;
//                })
//                .orElse(false);
    }
}
