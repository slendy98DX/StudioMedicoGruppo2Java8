package co.develhope.StudioMedicoGruppo2Java8.entities;

import co.develhope.StudioMedicoGruppo2Java8.enums.RecordStatus;
import jakarta.persistence.*;
@Entity
@Table(name = "patient")
public class Patient extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long patientId;

    @Column(unique = true)
    private String taxIdCode;

    @ManyToOne(fetch = FetchType.LAZY)
    private Doctor doctor;

    public Patient(String name, String surname, String email, String phoneNumber, RecordStatus recordStatus, Long patientId, String taxIdCode, Doctor doctor) {
        super(name, surname, email, phoneNumber, recordStatus);
        this.patientId = patientId;
        this.taxIdCode = taxIdCode;
        this.doctor = doctor;
    }

    public Patient() {
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getTaxIdCode() {
        return taxIdCode;
    }

    public void setTaxIdCode(String taxIdCode) {
        this.taxIdCode = taxIdCode;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
