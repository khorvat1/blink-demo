package hr.khorvat.blink.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

public enum SexType {
    MALE("M"), FEMALE("F"), OTHER("O");

    private final String value;

    SexType(final String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    @JsonCreator
    public static SexType forValue(final String value) {
        return new Mapper().convertToEntityAttribute(value);
    }

    @Converter(autoApply = true)
    public static final class Mapper implements AttributeConverter<SexType, String> {
        @Override
        public String convertToDatabaseColumn(SexType sexType) {
            if (sexType == null) {
                return null;
            }
            return sexType.getValue();
        }

        @Override
        public SexType convertToEntityAttribute(String value) {
            if (value == null) {
                return null;
            }

            return Stream.of(SexType.values())
                    .filter(c -> c.getValue().equals(value))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }
}
