package co.develhope.StudioMedicoGruppo2Java8.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "doctor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String doctorId;
    private String doctorName;
    private String doctorSurname;
    private String doctorSpecialization;
    @Column(unique = true)
    private String doctorEmail;
    private String officeContact;
    private String placeOfWork;
    private Integer workingDays;

}
