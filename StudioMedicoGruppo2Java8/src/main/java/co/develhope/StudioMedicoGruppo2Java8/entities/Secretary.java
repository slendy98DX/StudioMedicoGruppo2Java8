package co.develhope.StudioMedicoGruppo2Java8.entities;

import co.develhope.StudioMedicoGruppo2Java8.enums.RecordStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "secretary")
public class Secretary extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long secretaryId;
    private Integer workingDays;

    @ManyToOne(fetch = FetchType.LAZY)
    private Doctor doctor;

    public Secretary(String name, String surname, String email, String phoneNumber, RecordStatus recordStatus, Long secretaryId, Integer workingDays, Doctor doctor) {
        super(name, surname, email, phoneNumber, recordStatus);
        this.secretaryId = secretaryId;
        this.workingDays = workingDays;
        this.doctor = doctor;
    }

    public Secretary() {
    }

    public Long getSecretaryId() {
        return secretaryId;
    }

    public void setSecretaryId(Long secretaryId) {
        this.secretaryId = secretaryId;
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
