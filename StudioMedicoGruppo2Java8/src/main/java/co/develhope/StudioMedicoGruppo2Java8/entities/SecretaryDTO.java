package co.develhope.StudioMedicoGruppo2Java8.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "secretary")
public class SecretaryDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long secretaryId;
    private String secretaryName;
    private String secretarySurname;
    @Column(unique = true)
    private String secretaryEmail;
    @Column(unique = true)
    private String secretaryPhoneNumber;
    private Integer workingDays;

    @ManyToOne(fetch = FetchType.LAZY)
    private DoctorDTO doctorDTO;

    public SecretaryDTO(Long secretaryId, String secretaryName, String secretarySurname, String secretaryEmail, String secretaryPhoneNumber, Integer workingDays, DoctorDTO doctorDTO) {
        this.secretaryId = secretaryId;
        this.secretaryName = secretaryName;
        this.secretarySurname = secretarySurname;
        this.secretaryEmail = secretaryEmail;
        this.secretaryPhoneNumber = secretaryPhoneNumber;
        this.workingDays = workingDays;
        this.doctorDTO = doctorDTO;
    }

    public SecretaryDTO() {
    }

    public Long getSecretaryId() {
        return secretaryId;
    }

    public void setSecretaryId(Long secretaryId) {
        this.secretaryId = secretaryId;
    }

    public String getSecretaryName() {
        return secretaryName;
    }

    public void setSecretaryName(String secretaryName) {
        this.secretaryName = secretaryName;
    }

    public String getSecretarySurname() {
        return secretarySurname;
    }

    public void setSecretarySurname(String secretarySurname) {
        this.secretarySurname = secretarySurname;
    }

    public String getSecretaryEmail() {
        return secretaryEmail;
    }

    public void setSecretaryEmail(String secretaryEmail) {
        this.secretaryEmail = secretaryEmail;
    }

    public String getSecretaryPhoneNumber() {
        return secretaryPhoneNumber;
    }

    public void setSecretaryPhoneNumber(String secretaryPhoneNumber) {
        this.secretaryPhoneNumber = secretaryPhoneNumber;
    }

    public Integer getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(Integer workingDays) {
        this.workingDays = workingDays;
    }

    public DoctorDTO getDoctorDTO() {
        return doctorDTO;
    }

    public void setDoctorDTO(DoctorDTO doctorDTO) {
        this.doctorDTO = doctorDTO;
    }
}
