package hr.khorvat.blink.validation.validator;

import hr.khorvat.blink.model.dto.UserDocumentDTO;
import hr.khorvat.blink.validation.type.ValidUserDocument;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserDocumentValidator implements ConstraintValidator<ValidUserDocument, UserDocumentDTO> {

    public void initialize(ValidUserDocument constraintAnnotation) {
    }

    @Override
    public boolean isValid(UserDocumentDTO userDocumentDTO, ConstraintValidatorContext constraintValidatorContext) {

        if (userDocumentDTO.getImageURL() == null && userDocumentDTO.getImageBase64() == null){
            return false;
        }

        if ((userDocumentDTO.getImageURL() != null && userDocumentDTO.getImageURL().length() > 10 )
                || (userDocumentDTO.getImageBase64() != null && userDocumentDTO.getImageBase64().length() > 100)){
            return true;
        }

        return false;
    }
}
