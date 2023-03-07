package co.develhope.StudioMedicoGruppo2Java8.entities;

import co.develhope.StudioMedicoGruppo2Java8.enums.RecordStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "secretary")
public class Secretary extends Person{
    private Integer workingDays;

    @ManyToOne(fetch = FetchType.LAZY)
    private Doctor doctor;

    public Secretary(Long id, String name, String surname, String email, String phoneNumber, RecordStatus recordStatus, Integer workingDays, Doctor doctor) {
        super(id, name, surname, email, phoneNumber, recordStatus);
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
