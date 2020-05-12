package hr.khorvat.blink.repository;

import hr.khorvat.blink.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = {"addresses", "contacts"})
    Optional<User> findOneWithEagerRelationsById(Long id);
}
