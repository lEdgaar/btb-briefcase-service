package com.btb.briefcaseservice.common.validation.validators;

import com.btb.briefcaseservice.common.validation.annotations.NotNullOrEmpty;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class NotNullOrEmptyValidator implements ConstraintValidator<NotNullOrEmpty, CharSequence> {


    @Override
    public void initialize(NotNullOrEmpty constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(CharSequence value,ConstraintValidatorContext context) {
        return value != null && value.length() > 0;
    }
}
