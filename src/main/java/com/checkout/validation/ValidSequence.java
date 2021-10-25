package com.checkout.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
        ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidSequenceValidator.class)
@Documented
public @interface ValidSequence {
    String message () default "Only single uppercase alpha characters are accepted: [A-Z]";
    Class<?>[] groups () default {};

    Class<? extends Payload>[] payload () default {};
}
