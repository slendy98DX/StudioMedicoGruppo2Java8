package co.develhope.StudioMedicoGruppo2Java8.entities;

import jakarta.persistence.*;
@Entity
@Table(name = "patient")
public class PatientDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long patientId;
    private String patientName;
    private String patientSurname;
    @Column(unique = true)
    private String patientEmail;
    private String patientPhoneNumber;
    private String taxIdCode;

    @ManyToOne(fetch = FetchType.LAZY)
    private DoctorDTO doctorDTO;

    public PatientDTO(Long patientId, String patientName, String patientSurname, String patientEmail, String patientPhoneNumber, String taxIdCode, DoctorDTO doctorDTO) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientSurname = patientSurname;
        this.patientEmail = patientEmail;
        this.patientPhoneNumber = patientPhoneNumber;
        this.taxIdCode = taxIdCode;
        this.doctorDTO = doctorDTO;
    }

    public PatientDTO() {
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPatientPhoneNumber() {
        return patientPhoneNumber;
    }

    public void setPatientPhoneNumber(String patientPhoneNumber) {
        this.patientPhoneNumber = patientPhoneNumber;
    }

    public String getTaxIdCode() {
        return taxIdCode;
    }

    public void setTaxIdCode(String taxIdCode) {
        this.taxIdCode = taxIdCode;
    }

    public DoctorDTO getDoctorDTO() {
        return doctorDTO;
    }

    public void setDoctorDTO(DoctorDTO doctorDTO) {
        this.doctorDTO = doctorDTO;
    }
}
