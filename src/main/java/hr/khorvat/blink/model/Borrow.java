package hr.khorvat.blink.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "borrow", schema = "blink")
@Getter
@Setter
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "blink.pk_sequence", allocationSize = 1)
    private Long id;

    @NotNull
    @Column
    private LocalDate dateFrom;

    @NotNull
    @Column
    private LocalDate dateTo;

    @Column
    private LocalDate dateReturned;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "title_copy_id")
    private TitleCopy titleCopy;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "extend_id")
    private Borrow extend;

    @OneToMany(mappedBy = "extend")
    private Set<Borrow> extensions = new HashSet<Borrow>();
}
