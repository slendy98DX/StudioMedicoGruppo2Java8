package co.develhope.StudioMedicoGruppo2Java8.repositories;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.entities.Doctor;
import co.develhope.StudioMedicoGruppo2Java8.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findAllByPatient(Patient patient);

    Optional<Booking> findByPatient(Patient patient);

    Optional<Booking> findByDoctor(Doctor doctor);
    List<Booking> findAllByDoctor(Doctor doctor);

    void deleteByPatient(Patient patient);
}
