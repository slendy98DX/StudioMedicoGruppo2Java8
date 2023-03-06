package co.develhope.StudioMedicoGruppo2Java8.repositories;

import co.develhope.StudioMedicoGruppo2Java8.entities.BookingDTO;
import co.develhope.StudioMedicoGruppo2Java8.entities.PatientDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<BookingDTO, Long> {

    Optional<BookingDTO> findByPatientDTO(PatientDTO patientDTO);
}
