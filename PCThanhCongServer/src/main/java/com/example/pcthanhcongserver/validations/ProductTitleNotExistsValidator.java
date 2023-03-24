package com.example.pcthanhcongserver.validations;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductTitleNotExistsValidator implements ConstraintValidator<ProductTitleNotExists, String> {

    @Autowired
    private IP
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
