package co.develhope.StudioMedicoGruppo2Java8.entities.dto;

import co.develhope.StudioMedicoGruppo2Java8.enums.DoctorSpecialization;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class DoctorRequestDTO extends UserRequestDTO {

    private DoctorSpecialization doctorSpecialization;
    private String placeOfWork;
    private Integer workingDays;

    @Enumerated(EnumType.STRING)
    @Column(name = "doctorSpecialization")
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
