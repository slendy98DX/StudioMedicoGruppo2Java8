package co.develhope.StudioMedicoGruppo2Java8.entities;

import co.develhope.StudioMedicoGruppo2Java8.enums.RecordStatus;
import jakarta.persistence.*;


@Entity
@Table(name = "secretary")
public class Secretary extends User {
    private Integer workingDays;

    @ManyToOne(fetch = FetchType.EAGER)
    private Doctor doctor;

    public Secretary(Long id, String username, String name, String surname, String email, String phoneNumber, RecordStatus recordStatus, String password, String activationCode, Boolean active, Role role, Integer workingDays, Doctor doctor) {
        super(id, username, name, surname, email, phoneNumber, recordStatus, password, activationCode, active, role);
        this.workingDays = workingDays;
        this.doctor = doctor;
    }

    public Secretary() {
    }

    public Integer getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(Integer workingDays) {
        this.workingDays = workingDays;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
