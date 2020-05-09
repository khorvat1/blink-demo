package hr.khorvat.blink.model.mapper;

import hr.khorvat.blink.model.Address;
import hr.khorvat.blink.model.Contact;
import hr.khorvat.blink.model.User;
import hr.khorvat.blink.model.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setDateOfBirth(userDTO.getDateOfBirth());
        user.setSex(userDTO.getSex());

        userDTO.getAddresses().forEach(a -> {
            Address address = new Address();
            address.setId(a.getId());
            address.setStreet(a.getStreet());
            address.setCity(a.getCity());
            address.setState(a.getState());
            address.setType(a.getType());
            user.addAddress(address);
        });

        userDTO.getContacts().forEach(c -> {
            Contact contact = new Contact();
            contact.setId(c.getId());
            contact.setValue(c.getValue());
            contact.setType(c.getType());
            user.addContact(contact);
        });

        return user;
    }
}
