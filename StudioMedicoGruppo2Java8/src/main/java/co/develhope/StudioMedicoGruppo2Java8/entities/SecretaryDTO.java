package co.develhope.StudioMedicoGruppo2Java8.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "secretary")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecretaryDTO {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String secretaryId;
    private String secretaryName;
    private String secretarySurname;
    @Column(unique = true)
    private String secretaryEmail;
    @Column(unique = true)
    private String secretaryPhoneNumber;
    private Integer workingDays;

    @ManyToOne
    private DoctorDTO doctorDTO;
}
