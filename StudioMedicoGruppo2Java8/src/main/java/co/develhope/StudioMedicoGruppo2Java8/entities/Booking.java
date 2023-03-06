package co.develhope.StudioMedicoGruppo2Java8.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookingId;
    private LocalDate creationDate;
    private LocalDate bookingDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private Doctor doctor;

    @OneToOne(fetch = FetchType.EAGER)
    private Patient patient;

    public Booking(Long bookingId, LocalDate creationDate, LocalDate bookingDate, Doctor doctor, Patient patient) {
        this.bookingId = bookingId;
        this.creationDate = creationDate;
        this.bookingDate = bookingDate;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Booking() {
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

    public Doctor getDoctorDTO() {
        return doctor;
    }

    public void setDoctorDTO(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatientDTO() {
        return patient;
    }

    public void setPatientDTO(Patient patient) {
        this.patient = patient;
    }
}
