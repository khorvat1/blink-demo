package hr.khorvat.blink.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "mrz_validation", schema = "blink")
@Getter
@Setter
public class MRZValidation {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "blink.pk_sequence", allocationSize = 1)
    private Long id;
    @Column
    private String dateOfBirth;
    @Column
    private Integer dateOfBirthCheckDigit;
    @Column
    @Type(type = "numeric_boolean")
    private Boolean isDateOfBirthValid;
    @Column
    private String dateOfExpiry;
    @Column
    private Integer dateOfExpiryCheckDigit;
    @Column
    @Type(type = "numeric_boolean")
    private Boolean isDateOfExpiryValid;
    @Column
    private String documentNumber;
    @Column
    private Integer documentNumberCheckDigit;
    @Column
    @Type(type = "numeric_boolean")
    private Boolean isDocumentNumberValid;
    @Column
    private String compositeCheckString;
    @Column
    private Integer compositeCheckDigit;
    @Column
    @Type(type = "numeric_boolean")
    private Boolean isValid;
    @Column
    private Long objectId;
    @Column
    private String type;

}
