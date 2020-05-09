package hr.khorvat.blink.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import hr.khorvat.blink.model.Address;
import hr.khorvat.blink.model.Contact;
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

    @Getter
    @Setter
    @NoArgsConstructor
    public static class ContactDTO {
        private Long id;
        private String value;
        private String type;

        public ContactDTO(Contact contact) {
            super();
            this.id = contact.getId();
            this.value = contact.getValue();
            this.type = contact.getType();
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class AddressDTO {
        private Long id;
        private String street;
        private String city;
        private String state;
        private String type;

        public AddressDTO(Address address) {
            super();
            this.id = address.getId();
            this.street = address.getStreet();
            this.city = address.getCity();
            this.state = address.getState();
            this.type = address.getType();
        }
    }
}
