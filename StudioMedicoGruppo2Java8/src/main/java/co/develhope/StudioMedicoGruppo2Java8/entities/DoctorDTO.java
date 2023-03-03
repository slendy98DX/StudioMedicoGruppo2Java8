package co.develhope.StudioMedicoGruppo2Java8.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "doctor")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}