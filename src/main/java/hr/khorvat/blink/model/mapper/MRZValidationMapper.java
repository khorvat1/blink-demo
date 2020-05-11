package hr.khorvat.blink.model.mapper;

import hr.khorvat.blink.model.MRZValidation;
import hr.khorvat.blink.model.dto.MRZValidationDTO;
import org.springframework.stereotype.Component;

@Component
public class MRZValidationMapper {

    public MRZValidation toEntity(MRZValidationDTO mrzValidationDTO) {
        MRZValidation mrzValidation = new MRZValidation();
        mrzValidation.setDateOfBirth(mrzValidationDTO.getDateOfBirth());
        mrzValidation.setDateOfBirthCheckDigit(mrzValidationDTO.getDateOfBirthCheckDigit());
        mrzValidation.setIsDateOfBirthValid(mrzValidationDTO.getIsDateOfBirthValid());

        mrzValidation.setDateOfExpiry(mrzValidationDTO.getDateOfExpiry());
        mrzValidation.setDateOfExpiryCheckDigit(mrzValidationDTO.getDateOfExpiryCheckDigit());
        mrzValidation.setIsDateOfExpiryValid(mrzValidationDTO.getIsDateOfExpiryValid());

        mrzValidation.setDocumentNumber(mrzValidationDTO.getDocumentNumber());
        mrzValidation.setDocumentNumberCheckDigit(mrzValidationDTO.getDocumentNumberCheckDigit());
        mrzValidation.setIsDocumentNumberValid(mrzValidationDTO.getIsDocumentNumberValid());

        mrzValidation.setCompositeCheckString(mrzValidationDTO.getCompositeCheckString());
        mrzValidation.setCompositeCheckDigit(mrzValidationDTO.getCompositeCheckDigit());
        mrzValidation.setIsValid(mrzValidationDTO.getIsValid());

        return mrzValidation;
    }

}
