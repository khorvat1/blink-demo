package hr.khorvat.blink.service.impl;

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

    public void validateMRZFields(String rawMRZString) {
        String[] mrzStrings = splitMRZStringsForType1(rawMRZString);

        String documentNumber = mrzStrings[0].substring(5, 14);
        int documentNumberControl = Integer.valueOf(mrzStrings[0].substring(14, 15));
        boolean isDocumentNumberValid = checkDigitsUtil.isMRZStringValid(documentNumber, documentNumberControl);

        String dateOfBirth = mrzStrings[1].substring(0, 6);
        int dateOfBirthControl = Integer.valueOf(mrzStrings[1].substring(6, 7));
        boolean isDateOfBirthValid = checkDigitsUtil.isMRZStringValid(documentNumber, documentNumberControl);

        String dateOfExpiry = mrzStrings[1].substring(8, 14);
        int dateOfExpiryControl = Integer.valueOf(mrzStrings[1].substring(14, 15));
        boolean isDateOfExpiryValid = checkDigitsUtil.isMRZStringValid(documentNumber, documentNumberControl);

    }

    private String[] splitMRZStringsForType1(String rawMRZString) {
        String[] mrzParts = rawMRZString.split("\\n");
        if (mrzParts.length != 3) {
            throw new IllegalStateException("Invalid type 1 MRZ string");
        }
        return mrzParts;
    }
}