package co.develhope.StudioMedicoGruppo2Java8.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "booking")
public class BookingDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookingId;
    private LocalDate creationDate;
    private LocalDate bookingDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private DoctorDTO doctorDTO;

    @OneToOne(fetch = FetchType.EAGER)
    private PatientDTO patientDTO;

    public BookingDTO(Long bookingId, LocalDate creationDate, LocalDate bookingDate, DoctorDTO doctorDTO, PatientDTO patientDTO) {
        this.bookingId = bookingId;
        this.creationDate = creationDate;
        this.bookingDate = bookingDate;
        this.doctorDTO = doctorDTO;
        this.patientDTO = patientDTO;
    }

    public BookingDTO() {
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public DoctorDTO getDoctorDTO() {
        return doctorDTO;
    }

    public void setDoctorDTO(DoctorDTO doctorDTO) {
        this.doctorDTO = doctorDTO;
    }

    public PatientDTO getPatientDTO() {
        return patientDTO;
    }

    public void setPatientDTO(PatientDTO patientDTO) {
        this.patientDTO = patientDTO;
    }
}
