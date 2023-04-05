package co.develhope.StudioMedicoGruppo2Java8.entities;

import co.develhope.StudioMedicoGruppo2Java8.enums.RecordStatus;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@EntityListeners(AuditingEntityListener.class)
public class Booking extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private LocalDateTime bookingDate;

    private Integer bookingDuration;

    @Enumerated(EnumType.STRING)
    private RecordStatus recordStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.EAGER)
    private Patient patient;


    public Booking(Long bookingId, LocalDateTime bookingDate, Integer bookingDuration, RecordStatus recordStatus, Doctor doctor, Patient patient) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.bookingDuration = bookingDuration;
        this.recordStatus = recordStatus;
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

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public RecordStatus getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(RecordStatus recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Integer getBookingDuration() {
        return bookingDuration;
    }

    public void setBookingDuration(Integer bookingDuration) {
        this.bookingDuration = bookingDuration;
    }
}
