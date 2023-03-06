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
}
