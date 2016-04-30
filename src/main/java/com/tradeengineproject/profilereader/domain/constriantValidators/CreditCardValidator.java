package com.tradeengineproject.profilereader.domain.constriantValidators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class CreditCardValidator implements ConstraintValidator
{
    public void initialize(Annotation annotation)
    {

    }

    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext)
    {
        return false;
    }
}
