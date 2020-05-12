package hr.khorvat.blink;

import hr.khorvat.blink.model.dto.AddressDTO;
import hr.khorvat.blink.model.dto.ContactDTO;
import hr.khorvat.blink.model.dto.UserDocumentDTO;
import hr.khorvat.blink.model.enums.AddressType;
import hr.khorvat.blink.model.enums.ContactType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Set;

public class UserDocumentValidatorTest {

    private static Validator validator;

    @BeforeEach
    void init() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testUserDocumentValidator() {
        UserDocumentDTO dto1 = new UserDocumentDTO();
        Set<ConstraintViolation<UserDocumentDTO>> constraintViolations = validator.validate(dto1);
        Assertions.assertEquals(3, constraintViolations.size());

        UserDocumentDTO dto2 = new UserDocumentDTO();
        dto2.setImageURL("12345678901");
        constraintViolations = validator.validate(dto2);
        Assertions.assertEquals(2, constraintViolations.size());

        UserDocumentDTO dto3 = new UserDocumentDTO();
        dto3.setImageURL("12345678901");
        AddressDTO address = new AddressDTO();
        address.setStreet("A");
        address.setCity("B");
        address.setType(AddressType.RESIDENCE);
        dto3.setAddresses(new ArrayList<>() {{
            add(address);
        }});
        ContactDTO contact = new ContactDTO();
        contact.setValue("A");
        contact.setType(ContactType.MOBILE);
        dto3.setContacts(new ArrayList<>() {{
            add(contact);
        }});
        constraintViolations = validator.validate(dto3);
        Assertions.assertEquals(0, constraintViolations.size());
    }
}
