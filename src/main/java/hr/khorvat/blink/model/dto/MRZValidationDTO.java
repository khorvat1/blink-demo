package hr.khorvat.blink.model.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MRZValidationDTO implements Serializable {

    private String dateOfBirth;
    private Integer dateOfBirthCheckDigit;
    private Boolean isDateOfBirthValid;
    private String dateOfExpiry;
    private Integer dateOfExpiryCheckDigit;
    private Boolean isDateOfExpiryValid;
    private String documentNumber;
    private Integer documentNumberCheckDigit;
    private Boolean isDocumentNumberValid;
    private String compositeCheckString;
    private Integer compositeCheckDigit;
    private Boolean isValid;

}
