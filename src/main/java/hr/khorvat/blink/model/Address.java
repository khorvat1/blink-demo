package hr.khorvat.blink.model;

import hr.khorvat.blink.model.enums.AddressType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "address", schema = "blink")
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "blink.pk_sequence", allocationSize = 1)
    private Long id;

    @NotNull
    @Column
    private String street;

    @NotNull
    @Column
    private String city;

    @Column
    private String state;

    @NotNull
    @Column
    @Enumerated(EnumType.STRING)
    private AddressType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
