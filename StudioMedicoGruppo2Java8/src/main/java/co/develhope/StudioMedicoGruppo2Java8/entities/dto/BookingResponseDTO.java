package co.develhope.StudioMedicoGruppo2Java8.entities.dto;

import java.time.LocalDateTime;

public class BookingResponseDTO {

    private LocalDateTime bookingDate;

    private PatientResponseDTO patient;

    private DoctorResponseDTO doctor;

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public PatientResponseDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientResponseDTO patient) {
        this.patient = patient;
    }

    public DoctorResponseDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorResponseDTO doctor) {
        this.doctor = doctor;
    }
}
