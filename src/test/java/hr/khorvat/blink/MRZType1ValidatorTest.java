package hr.khorvat.blink;

import hr.khorvat.blink.model.dto.MRZValidationDTO;
import hr.khorvat.blink.service.MRZType1Validator;
import hr.khorvat.blink.service.impl.MRZType1ValidatorImpl;
import hr.khorvat.blink.util.CheckDigitsUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MRZType1ValidatorTest {

    private CheckDigitsUtil checkDigitsUtil;
    private MRZType1Validator mrzType1Validator;

    @BeforeEach
    void init() {
        this.checkDigitsUtil = new CheckDigitsUtil();
        this.mrzType1Validator = new MRZType1ValidatorImpl(checkDigitsUtil);
    }

    @Test
    void testValidateMRZFields(){
        MRZValidationDTO result1 = mrzType1Validator
                .validateMRZFields("IOHRV0000000000<<<<<<<<<<<<<<<\n7701018F0212126HRV<<<<<<<<<<<0\nCDECIMEM<<EDECIMEM<<<<<<<<<<<<\n");
        Assertions.assertEquals(true, result1.getIsValid());

        MRZValidationDTO result2 = mrzType1Validator
                .validateMRZFields("IOHRV0000000000<<<<<<<<<<<<<<<\n7701018M0212126HRV<<<<<<<<<<<0\nCDECIMEM<<EDECIMEM<<<<<<<<<<<<\n");
        Assertions.assertEquals(true, result2.getIsValid());

        MRZValidationDTO result3 = mrzType1Validator
                .validateMRZFields("IOHRV0000000000<<<<<<<<<<<<<<<\n7701018F0212127HRV<<<<<<<<<<<0\nCDECIMEM<<EDECIMEM<<<<<<<<<<<<\n");
        Assertions.assertEquals(false, result3.getIsValid());

        MRZValidationDTO result4 = mrzType1Validator
                .validateMRZFields("IOHRV123456789701234567896<<<<\n7701018M2307013HRV<<<<<<<<<<<1\nUZORAK<<SPECIMEN<<<<<<<<<<<<<<\n");
        Assertions.assertEquals(true, result4.getIsValid());
    }
}
