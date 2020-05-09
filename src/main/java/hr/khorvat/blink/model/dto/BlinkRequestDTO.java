package hr.khorvat.blink.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BlinkRequestDTO implements Serializable {

    private boolean detectGlare;
    private boolean exportImages;
    private boolean exportMrzImage;
    private boolean exportFullDocumentImage;
    private String debug;
    private final String recognizerType;
    private final String imageURL;
    private final String imageBase64;

    public BlinkRequestDTO(String imageURL, String imageBase64) {
        if (imageURL == null && imageBase64 == null) {
            throw new IllegalArgumentException("Image url or image base 64 string must be provided");
        }
        this.recognizerType = "MRTD";
        this.imageURL = imageURL;
        this.imageBase64 = imageBase64;
    }
}
