package co.develhope.StudioMedicoGruppo2Java8.repositories;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAllByPatientId(Long id);
    List<Booking> findAllByBookingDateAndDoctorId(LocalDate localDate, Long id);
    List<Booking> findAllByDoctorId(Long id);

}
