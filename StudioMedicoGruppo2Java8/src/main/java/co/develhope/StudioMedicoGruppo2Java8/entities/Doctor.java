package co.develhope.StudioMedicoGruppo2Java8.entities;

import co.develhope.StudioMedicoGruppo2Java8.enums.RecordStatus;
import jakarta.persistence.*;
@Entity
@Table(name = "doctor")
public class Doctor extends Person{

    public enum DoctorSpecialization{
        CARDIOLOGO,
        ANDROLOGO,
        PODOLOGO,
        GINECOLOGO,
        UROLOGO,
        PEDIATRA
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long doctorId;
    @Enumerated(EnumType.STRING)
    @Column(name = "doctorSpecialization")
    private DoctorSpecialization doctorSpecialization;
    private String placeOfWork;
    private Integer workingDays;

    public Doctor(String name, String surname, String email, String phoneNumber, RecordStatus recordStatus, Long doctorId, DoctorSpecialization doctorSpecialization, String placeOfWork, Integer workingDays) {
        super(name, surname, email, phoneNumber, recordStatus);
        this.doctorId = doctorId;
        this.doctorSpecialization = doctorSpecialization;
        this.placeOfWork = placeOfWork;
        this.workingDays = workingDays;
    }

    public Doctor() {
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
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
