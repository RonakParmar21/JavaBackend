package com.module2.ronak.hw.module2SpringBootMVCAndRestfulAPIHW.annotations;

import jakarta.persistence.Enumerated;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeNumberValidator implements ConstraintValidator<PrimeNumberValidation, Integer> {
    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        if (integer <= 1) return false;
        for (int i = 2; i <= Math.sqrt(integer); i++)
            if (integer % i == 0)
                return false;
        return false;
    }
}
