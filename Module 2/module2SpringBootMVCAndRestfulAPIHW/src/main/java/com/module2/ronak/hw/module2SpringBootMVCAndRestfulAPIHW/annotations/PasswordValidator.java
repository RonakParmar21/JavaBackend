package com.module2.ronak.hw.module2SpringBootMVCAndRestfulAPIHW.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordValidation, String> {
    private static final int MIN_LENGTH = 10;
    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        if (password == null || password.length() < MIN_LENGTH) return false;

        boolean hasUpercase = false;
        boolean hasLowercase = false;
        boolean hasSpecialCharacter = false;

        int len = password.length();
        for (int i = 0; i < len; i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) hasUpercase = true;
            else if (Character.isLowerCase(ch)) hasLowercase = true;
            else if (!Character.isLetterOrDigit(ch)) hasSpecialCharacter = true;

            if(hasLowercase && hasLowercase && hasSpecialCharacter) return true;
        }

        return hasUpercase && hasLowercase && hasSpecialCharacter;
    }
}
