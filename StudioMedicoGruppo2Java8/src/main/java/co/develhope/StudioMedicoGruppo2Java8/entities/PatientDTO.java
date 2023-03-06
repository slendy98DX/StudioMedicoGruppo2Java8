package co.develhope.StudioMedicoGruppo2Java8.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
