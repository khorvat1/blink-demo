package hr.khorvat.blink.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "title", schema = "blink")
@Getter
@Setter
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "blink.pk_sequence", allocationSize = 1)
    private Long id;

    @NotNull
    @Column
    private String title;

    @NotNull
    @Column
    private Integer year;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "title")
    private Set<TitleCopy> copies = new HashSet<>();
}
