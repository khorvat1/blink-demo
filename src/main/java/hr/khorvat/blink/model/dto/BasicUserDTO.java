package hr.khorvat.blink.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import hr.khorvat.blink.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BasicUserDTO implements Serializable {

    public BasicUserDTO(User user) {
        super();
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.dateOfBirth = user.getDateOfBirth().toString();
        this.sex = user.getSex();
    }

    private Long id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String sex;

}
