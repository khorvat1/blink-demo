package hr.khorvat.blink.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDocumentDTO implements Serializable {

    private String imageURL;
    private String imageBase64;
    private List<ContactDTO> contacts;
    private List<AddressDTO> addresses;
}
