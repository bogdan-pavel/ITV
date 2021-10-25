package com.checkout.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ValidSequenceValidator implements ConstraintValidator<ValidSequence, List<String>> {

    @Override
    public void initialize(ValidSequence validSequence) {

    }

    @Override
    public boolean isValid(List<String> skus, ConstraintValidatorContext constraintValidatorContext) {
        return skus.stream().noneMatch(sku -> sku.length() != 1 || (sku.charAt(0) < 65 || sku.charAt(0) > 90));
    }
}
