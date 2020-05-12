package hr.khorvat.blink.model;

import hr.khorvat.blink.model.enums.ContactType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contact", schema = "blink")
@Getter
@Setter
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "blink.pk_sequence", allocationSize = 1)
    private Long id;

    @NotNull
    @Column
    private String value;

    @NotNull
    @Column
    @Enumerated(EnumType.STRING)
    private ContactType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
