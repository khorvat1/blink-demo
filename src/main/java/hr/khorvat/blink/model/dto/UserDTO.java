package hr.khorvat.blink.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import hr.khorvat.blink.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO extends BasicUserDTO {

    public UserDTO(User user) {
        super(user);
        this.addresses = user.getAddresses().stream().map(AddressDTO::new).collect(Collectors.toList());
        this.contacts = user.getContacts().stream().map(ContactDTO::new).collect(Collectors.toList());
    }

    private List<ContactDTO> contacts;
    private List<AddressDTO> addresses;

}
