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
@Table
public class Patient {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String patientId;
    private String patientName;
    private String patientSurname;
    @Column(unique = true)
    private String patientEmail;
    private String patientPhoneNumber;
    private String taxIdCode;


}
