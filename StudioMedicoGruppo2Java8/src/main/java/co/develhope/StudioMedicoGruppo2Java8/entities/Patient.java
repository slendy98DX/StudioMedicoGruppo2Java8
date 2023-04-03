package co.develhope.StudioMedicoGruppo2Java8.entities;

import co.develhope.StudioMedicoGruppo2Java8.enums.RecordStatus;
import jakarta.persistence.*;


@Entity
@Table(name = "patient")
public class Patient extends User {

    @Column(unique = true)
    private String taxIdCode;

    @ManyToOne(fetch = FetchType.EAGER)
    private Doctor doctor;

    public Patient(Long id, String username, String name, String surname, String email, String phoneNumber, RecordStatus recordStatus, String password, String activationCode, Boolean active, Role role, String taxIdCode, Doctor doctor) {
        super(id, username, name, surname, email, phoneNumber, recordStatus, password, activationCode, active, role);
        this.taxIdCode = taxIdCode;
        this.doctor = doctor;
    }

    public Patient() {
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
