package hr.khorvat.blink;

import hr.khorvat.blink.util.CheckDigitsUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckDigitsUtilTest {

    private CheckDigitsUtil checkDigitsUtil;

    @BeforeEach
    void init() {
        this.checkDigitsUtil = new CheckDigitsUtil();
    }

    @Test
    void testIsMRZStringValid(){
        Assertions.assertEquals(true, checkDigitsUtil.isMRZStringValid("520727", 3));
        Assertions.assertEquals(false, checkDigitsUtil.isMRZStringValid("520727", 4));
        Assertions.assertEquals(true, checkDigitsUtil.isMRZStringValid("L898902C<", 3));
        Assertions.assertEquals(false, checkDigitsUtil.isMRZStringValid("L898902C<", 4));
    }

    @Test
    void testCheckDigits(){
        Assertions.assertEquals(3, checkDigitsUtil.calculateCheckDigit("520727"));
        Assertions.assertEquals(8, checkDigitsUtil.calculateCheckDigit("770101"));
        Assertions.assertEquals(7, checkDigitsUtil.calculateCheckDigit("D23145890"));
        Assertions.assertEquals(3, checkDigitsUtil.calculateCheckDigit("L898902C<"));
    }

    @Test
    void testCharValue(){
        Assertions.assertEquals(0, checkDigitsUtil.charValue('0'));
        Assertions.assertEquals(1, checkDigitsUtil.charValue('1'));
        Assertions.assertEquals(9, checkDigitsUtil.charValue('9'));
        Assertions.assertEquals(10, checkDigitsUtil.charValue('A'));
        Assertions.assertEquals(20, checkDigitsUtil.charValue('K'));
        Assertions.assertEquals(35, checkDigitsUtil.charValue('Z'));
        Assertions.assertThrows(IllegalStateException.class, () -> checkDigitsUtil.charValue('a'));
    }
}
