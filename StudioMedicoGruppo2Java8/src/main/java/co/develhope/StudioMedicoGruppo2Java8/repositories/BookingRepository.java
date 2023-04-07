package co.develhope.StudioMedicoGruppo2Java8.repositories;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.entities.dto.BookingResponseDTO;
import co.develhope.StudioMedicoGruppo2Java8.enums.RecordStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<BookingResponseDTO> findAllByBookingDateAndDoctorId(LocalDate localDate, Long id);

    Optional<Booking> findByPatientIdAndBookingId(Long patientId, Long bookingId);

    List<BookingResponseDTO> findAllByPatientIdAndRecordStatus(Long id, RecordStatus recordStatus);

    List<Booking> findByBookingDate(LocalDateTime bookingDate);
}
