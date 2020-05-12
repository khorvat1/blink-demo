package hr.khorvat.blink.repository;

import hr.khorvat.blink.model.MRZValidation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MRZValidationRepository extends JpaRepository<MRZValidation, Long> {

}
