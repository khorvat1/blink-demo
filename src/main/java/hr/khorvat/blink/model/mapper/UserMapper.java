package hr.khorvat.blink.model.mapper;

import hr.khorvat.blink.model.Address;
import hr.khorvat.blink.model.Contact;
import hr.khorvat.blink.model.User;
import hr.khorvat.blink.model.dto.BlinkResponseDTO;
import hr.khorvat.blink.model.dto.UserDTO;
import hr.khorvat.blink.model.dto.UserDocumentDTO;
import hr.khorvat.blink.model.enums.SexType;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserMapper {

    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setDateOfBirth(userDTO.getDateOfBirth());
        user.setSex(userDTO.getSex());

        userDTO.getAddresses().forEach(a -> {
            Address address = new Address();
            address.setStreet(a.getStreet());
            address.setCity(a.getCity());
            address.setState(a.getState());
            address.setType(a.getType());
            user.addAddress(address);
        });

        userDTO.getContacts().forEach(c -> {
            Contact contact = new Contact();
            contact.setValue(c.getValue());
            contact.setType(c.getType());
            user.addContact(contact);
        });

        return user;
    }

    public User toEntity(BlinkResponseDTO blinkResponseDTO, UserDocumentDTO userDocumentDTO) {
        User user = new User();
        user.setFirstName(blinkResponseDTO.getData().getResult().getPrimaryID());
        user.setLastName(blinkResponseDTO.getData().getResult().getSecondaryID());
        BlinkResponseDTO.BlinkResponseDataDateFormat dateOfBirth = blinkResponseDTO.getData().getResult().getDateOfBirth();
        user.setDateOfBirth(LocalDate.of(dateOfBirth.getYear(), dateOfBirth.getMonth(), dateOfBirth.getDay()));
        user.setSex(SexType.forValue(blinkResponseDTO.getData().getResult().getSex()));

        userDocumentDTO.getAddresses().forEach(a -> {
            Address address = new Address();
            address.setStreet(a.getStreet());
            address.setCity(a.getCity());
            address.setState(a.getState());
            address.setType(a.getType());
            user.addAddress(address);
        });

        userDocumentDTO.getContacts().forEach(c -> {
            Contact contact = new Contact();
            contact.setValue(c.getValue());
            contact.setType(c.getType());
            user.addContact(contact);
        });

        return user;
    }

    public User patchEntity(UserDTO userDTO, User user) {
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setDateOfBirth(userDTO.getDateOfBirth());
        user.setSex(userDTO.getSex());

        user.getAddresses().clear();
        user.getContacts().clear();

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
