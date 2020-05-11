package hr.khorvat.blink.validation.type;

import hr.khorvat.blink.validation.validator.UserDocumentValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UserDocumentValidator.class})
public @interface ValidUserDocument {

    String message() default "ImageURL or image base 64 string must be provided";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}