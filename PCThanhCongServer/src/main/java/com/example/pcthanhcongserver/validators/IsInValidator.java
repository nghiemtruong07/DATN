package com.example.pcthanhcongserver.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class IsInValidator implements ConstraintValidator<Isln, String> {

    private String[] value;

    @Override
    public void initialize(Isln constraintAnnotation){
        this.value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String fieldValue, ConstraintValidatorContext constraintValidatorContext) {
        if(fieldValue != null) {
            return Arrays.asList(this.value).contains(fieldValue);
        }
        return true;
    }
}
