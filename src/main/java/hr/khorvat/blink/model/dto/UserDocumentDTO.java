package hr.khorvat.blink.model.dto;

import hr.khorvat.blink.validation.type.ValidUserDocument;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ValidUserDocument
public class UserDocumentDTO implements Serializable {

    private String imageURL;
    private String imageBase64;

    @NotNull
    @Size(min = 1)
    @Valid
    private List<ContactDTO> contacts;

    @NotNull
    @Size(min = 1)
    @Valid
    private List<AddressDTO> addresses;
}
