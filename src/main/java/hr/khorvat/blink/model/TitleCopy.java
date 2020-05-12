package hr.khorvat.blink.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "title_copy", schema = "blink")
@Getter
@Setter
public class TitleCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "blink.pk_sequence", allocationSize = 1)
    private Long id;

    @NotNull
    @Column
    private String code;

    @NotNull
    @Column
    private String condition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "title_id")
    private Title title;
}
