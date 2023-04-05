package co.develhope.StudioMedicoGruppo2Java8.entities;

import co.develhope.StudioMedicoGruppo2Java8.enums.RecordStatus;
import jakarta.persistence.*;


@Entity
@Table(name = "secretary")
public class Secretary extends Person {
    private Integer workingDays;

    public Secretary(Long id, String username, String name, String surname, String email, String phoneNumber, RecordStatus recordStatus, String password, String activationCode, Boolean active, Integer workingDays) {
        super(id, username, name, surname, email, phoneNumber, recordStatus, password, activationCode, active);
        this.workingDays = workingDays;
    }

    public Secretary() {
    }

    public Integer getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(Integer workingDays) {
        this.workingDays = workingDays;
    }
}
