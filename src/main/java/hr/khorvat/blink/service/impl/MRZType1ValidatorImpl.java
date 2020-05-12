package hr.khorvat.blink.service.impl;

import hr.khorvat.blink.model.dto.MRZValidationDTO;
import hr.khorvat.blink.service.MRZType1Validator;
import hr.khorvat.blink.util.CheckDigitsUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MRZType1ValidatorImpl implements MRZType1Validator {

    private final CheckDigitsUtil checkDigitsUtil;

    public MRZValidationDTO validateMRZFields(String rawMRZString) {
        String[] mrzStrings = splitMRZStringsForType1(rawMRZString);
        MRZValidationDTO.MRZValidationDTOBuilder builder = MRZValidationDTO.builder();

        String documentNumber = mrzStrings[0].substring(5, 14);
        Integer documentNumberControl = Integer.valueOf(mrzStrings[0].substring(14, 15));
        builder.documentNumber(documentNumber);
        builder.documentNumberCheckDigit(documentNumberControl);
        builder.isDocumentNumberValid(checkDigitsUtil.isMRZStringValid(documentNumber, documentNumberControl));

        String dateOfBirth = mrzStrings[1].substring(0, 6);
        Integer dateOfBirthControl = Integer.valueOf(mrzStrings[1].substring(6, 7));
        builder.dateOfBirth(dateOfBirth);
        builder.dateOfBirthCheckDigit(dateOfBirthControl);
        builder.isDateOfBirthValid(checkDigitsUtil.isMRZStringValid(documentNumber, documentNumberControl));

        String dateOfExpiry = mrzStrings[1].substring(8, 14);
        Integer dateOfExpiryControl = Integer.valueOf(mrzStrings[1].substring(14, 15));
        builder.dateOfExpiry(dateOfExpiry);
        builder.dateOfExpiryCheckDigit(dateOfExpiryControl);
        builder.isDateOfExpiryValid(checkDigitsUtil.isMRZStringValid(documentNumber, documentNumberControl));

        String compositeDigitCheck = new StringBuilder()
                .append(mrzStrings[0].substring(5))
                .append(mrzStrings[1], 0, 7)
                .append(mrzStrings[1], 8, 15)
                .append(mrzStrings[1], 18, mrzStrings[1].length() - 1)
                .toString();
        Integer compositeDigitControl = Integer.valueOf(mrzStrings[1].substring(mrzStrings[1].length() - 1));
        builder.compositeCheckString(compositeDigitCheck);
        builder.compositeCheckDigit(compositeDigitControl);
        builder.isValid(checkDigitsUtil.isMRZStringValid(compositeDigitCheck, compositeDigitControl));

        return builder.build();
    }

    private String[] splitMRZStringsForType1(String rawMRZString) {
        String[] mrzParts = rawMRZString.split("\\n");
        if (mrzParts.length != 3) {
            throw new IllegalStateException("Invalid type 1 MRZ string");
        }
        return mrzParts;
    }
}