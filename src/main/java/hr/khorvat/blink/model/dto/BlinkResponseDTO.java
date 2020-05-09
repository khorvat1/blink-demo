package hr.khorvat.blink.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class BlinkResponseDTO implements Serializable {

    private String code;
    private String summary;
    private String executionId;
    private BlinkResponseData data;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class BlinkResponseData {
        private String recognizer;
        private String version;
        private Date startTime;
        private Date finishTime;
        private Double durationTimeInSeconds;
        private Integer taskId;
        private Integer workerId;
        private BlinkResponseDataResult result;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class BlinkResponseDataResult{
        private String primaryID;
        private String secondaryID;
        private String documentCode;
        private String documentNumber;
        private String documentType;
        private String issuer;
        private String issuerName;
        private String sex;
        private String nationality;
        private String nationalityName;
        private String alienNumber;
        private String applicationReceiptNumber;
        private String immigrantCaseNumber;
        private Boolean mrtdVerified;
        private String opt1;
        private String opt2;
        private String rawMRZString;
        private Integer age;
        private Boolean isBelowAgeLimit;
        private String type;
        private BlinkResponseDataDateFormat dateOfBirth;
        private BlinkResponseDataDateFormat dateOfExpiry;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class BlinkResponseDataDateFormat{
        private Integer day;
        private Integer month;
        private Integer year;
        private String originalString;
    }

}