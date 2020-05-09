package hr.khorvat.blink.model;

import hr.khorvat.blink.model.enums.SexType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "the_user", schema = "blink")
@Getter
@Setter
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "blink.pk_sequence", allocationSize = 1)
    private Long id;

    @NotNull
    @Column
    private String firstName;

    @NotNull
    @Column
    private String lastName;

    @NotNull
    @Column
    private Date dateOfBirth;

    @NotNull
    private SexType sex;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Address> addresses = new HashSet<>();

    public User addAddress(Address address){
        this.addresses.add(address);
        address.setUser(this);
        return this;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Contact> contacts = new HashSet<>();

    public User addContact(Contact contact){
        this.contacts.add(contact);
        contact.setUser(this);
        return this;
    }
}
