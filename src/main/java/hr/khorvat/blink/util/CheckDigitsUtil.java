package hr.khorvat.blink.util;

import org.springframework.stereotype.Component;

@Component
public class CheckDigitsUtil {

    private final Integer[] MRZ_WEIGHT = new Integer[]{7, 3, 1};

    public boolean isMRZStringValid(String valueString, int checkDigit){
        return calculateCheckDigit(valueString) == checkDigit;
    }

    public int calculateCheckDigit(String valueString) {
        int result = 0;
        for (int i = 0; i < valueString.length(); i++) {
            result += charValue(valueString.charAt(i)) * MRZ_WEIGHT[i % MRZ_WEIGHT.length];
        }

        return result % 10;
    }

    public int charValue(char element) {
        if (element == '<') {
            return 0;
        }
        if (element >= '0' && element <= '9') {
            return (int) element - 48;
        }
        if (element >= 'A' && element <= 'Z') {
            return (int) element - 65 + 10;
        }
        throw new IllegalStateException("Unsupported character");
    }

}
