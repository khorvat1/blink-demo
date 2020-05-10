package hr.khorvat.blink;

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
        mrzType1Validator.validateMRZFields("IOHRV0000000000<<<<<<<<<<<<<<<\n7701018F0212126HRV<<<<<<<<<<<0\nCDECIMEM<<EDECIMEM<<<<<<<<<<<<\n");
    }
}
