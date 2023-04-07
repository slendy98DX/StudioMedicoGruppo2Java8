package co.develhope.StudioMedicoGruppo2Java8.entities.dto;

import co.develhope.StudioMedicoGruppo2Java8.entities.Doctor;

public class PatientRequestDTO extends PersonRequestDTO{

    private String taxIdCode;

    private Doctor doctor;

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
