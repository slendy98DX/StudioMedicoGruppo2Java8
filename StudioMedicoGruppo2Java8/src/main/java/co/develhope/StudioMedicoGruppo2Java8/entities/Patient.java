package co.develhope.StudioMedicoGruppo2Java8.entities;

import co.develhope.StudioMedicoGruppo2Java8.enums.RecordStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "patient")
public class Patient extends Person{

    @Column(unique = true)
    private String taxIdCode;

    @ManyToOne(fetch = FetchType.EAGER)
    private Doctor doctor;

    public Patient(Long id, String name, String surname, String email, String phoneNumber, RecordStatus recordStatus, Date createdOn, Date modifiedOn, String taxIdCode, Doctor doctor) {
        super(id, name, surname, email, phoneNumber, recordStatus, createdOn, modifiedOn);
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
