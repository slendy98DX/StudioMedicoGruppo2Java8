package co.develhope.StudioMedicoGruppo2Java8.entities.dto;

import co.develhope.StudioMedicoGruppo2Java8.entities.Doctor;
import co.develhope.StudioMedicoGruppo2Java8.entities.Patient;

import java.time.LocalDateTime;

public class BookingRequestDTO {

    private LocalDateTime bookingDate;

    private Patient patient;

    private Doctor doctor;

    private Integer bookingDuration;


    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Integer getBookingDuration() {
        return bookingDuration;
    }

    public void setBookingDuration(Integer bookingDuration) {
        this.bookingDuration = bookingDuration;
    }
}
