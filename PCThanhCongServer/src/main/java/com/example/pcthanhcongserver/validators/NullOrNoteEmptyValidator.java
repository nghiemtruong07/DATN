package com.example.pcthanhcongserver.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NullOrNoteEmptyValidator implements ConstraintValidator<NullOrNotEmpty, Object> {

    @Override
    public void initialize(NullOrNotEmpty constraintAnnotation){

    }
    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        if(object == null){
            return true;
        }
        return String.valueOf(object).length() > 0;
    }
}
