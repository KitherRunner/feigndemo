package com.kither.annotation;

import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 值必须相等注解
 */
public class EqualsValidator implements ConstraintValidator<Equals, String> {

    private String equalsValue;

    @Override
    public void initialize(Equals constraintAnnotation) {
        equalsValue = constraintAnnotation.value();
        if (StringUtils.isBlank(equalsValue)) {
            equalsValue = "";
        }
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return equalsValue.equals(value);
    }
}
