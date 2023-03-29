package co.develhope.StudioMedicoGruppo2Java8.entities;

import co.develhope.StudioMedicoGruppo2Java8.enums.DoctorSpecialization;
import co.develhope.StudioMedicoGruppo2Java8.enums.RecordStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "doctor")
public class Doctor extends Person{



    @Enumerated(EnumType.STRING)
    @Column(name = "doctorSpecialization")
    private DoctorSpecialization doctorSpecialization;
    private String placeOfWork;
    private Integer workingDays;

    public Doctor(Long id, String name, String surname, String email, String phoneNumber, RecordStatus recordStatus, DoctorSpecialization doctorSpecialization, String placeOfWork, Integer workingDays) {
        super(id, name, surname, email, phoneNumber, recordStatus);
        this.doctorSpecialization = doctorSpecialization;
        this.placeOfWork = placeOfWork;
        this.workingDays = workingDays;
    }

    public Doctor() {
    }

    public DoctorSpecialization getDoctorSpecialization() {
        return doctorSpecialization;
    }

    public void setDoctorSpecialization(DoctorSpecialization doctorSpecialization) {
        this.doctorSpecialization = doctorSpecialization;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public Integer getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(Integer workingDays) {
        this.workingDays = workingDays;
    }
}
