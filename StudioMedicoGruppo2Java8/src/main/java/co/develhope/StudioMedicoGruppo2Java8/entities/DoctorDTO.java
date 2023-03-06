package co.develhope.StudioMedicoGruppo2Java8.entities;

import jakarta.persistence.*;
@Entity
@Table(name = "doctor")
public class DoctorDTO {

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
    private String doctorName;
    private String doctorSurname;
    @Enumerated(EnumType.STRING)
    @Column(name = "doctorSpecialization")
    private DoctorSpecialization doctorSpecialization;
    @Column(unique = true)
    private String doctorEmail;
    private String officeContact;
    private String placeOfWork;
    private Integer workingDays;

    public DoctorDTO(Long doctorId, String doctorName, String doctorSurname, DoctorSpecialization doctorSpecialization, String doctorEmail, String officeContact, String placeOfWork, Integer workingDays) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorSurname = doctorSurname;
        this.doctorSpecialization = doctorSpecialization;
        this.doctorEmail = doctorEmail;
        this.officeContact = officeContact;
        this.placeOfWork = placeOfWork;
        this.workingDays = workingDays;
    }

    public DoctorDTO() {
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorSurname() {
        return doctorSurname;
    }

    public void setDoctorSurname(String doctorSurname) {
        this.doctorSurname = doctorSurname;
    }

    public DoctorSpecialization getDoctorSpecialization() {
        return doctorSpecialization;
    }

    public void setDoctorSpecialization(DoctorSpecialization doctorSpecialization) {
        this.doctorSpecialization = doctorSpecialization;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public String getOfficeContact() {
        return officeContact;
    }

    public void setOfficeContact(String officeContact) {
        this.officeContact = officeContact;
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
