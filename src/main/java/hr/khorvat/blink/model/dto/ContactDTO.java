package hr.khorvat.blink.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import hr.khorvat.blink.model.Contact;
import hr.khorvat.blink.model.enums.ContactType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactDTO implements Serializable {

    private Long id;
    private String value;
    private ContactType type;

    public ContactDTO(Contact contact) {
        super();
        this.id = contact.getId();
        this.value = contact.getValue();
        this.type = contact.getType();
    }
}
