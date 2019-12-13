package org.example.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomValidator implements ConstraintValidator<CustomAnnotation, String> {

    private String prefix;

    @Override
    public void initialize(CustomAnnotation constraintAnnotation) {
        prefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        return null == s || s.startsWith(prefix);
    }
}
