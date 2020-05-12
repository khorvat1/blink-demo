package hr.khorvat.blink.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import hr.khorvat.blink.model.Address;
import hr.khorvat.blink.model.enums.AddressType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDTO implements Serializable {

    private Long id;
    @NotNull
    private String street;
    @NotNull
    private String city;
    private String state;
    @NotNull
    private AddressType type;

    public AddressDTO(Address address) {
        super();
        this.id = address.getId();
        this.street = address.getStreet();
        this.city = address.getCity();
        this.state = address.getState();
        this.type = address.getType();
    }
}
