package com.example.pcthanhcongserver.validations;

import com.example.pcthanhcongserver.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductTitleNotExistsValidator implements ConstraintValidator<ProductTitleNotExists, String> {

    @Autowired
    private IProductService service;
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext)
    {
        if(StringUtils.isEmpty(value))
            return true;
        return !service.existsProductByTitle(value);
    }
}
