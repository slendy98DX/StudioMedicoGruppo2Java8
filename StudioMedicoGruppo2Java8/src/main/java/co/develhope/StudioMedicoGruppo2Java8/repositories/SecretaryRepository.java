package co.develhope.StudioMedicoGruppo2Java8.repositories;
import co.develhope.StudioMedicoGruppo2Java8.entities.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecretaryRepository extends JpaRepository<Secretary, Long> {
    Optional<Secretary> findByEmail(String email);
}
