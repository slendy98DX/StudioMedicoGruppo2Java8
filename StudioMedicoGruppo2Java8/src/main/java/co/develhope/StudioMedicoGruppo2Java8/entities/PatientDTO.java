package co.develhope.StudioMedicoGruppo2Java8.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class PatientDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String patientId;
    private String patientName;
    private String patientSurname;
    @Column(unique = true)
    private String patientEmail;
    private String patientPhoneNumber;
    private String taxIdCode;

    @ManyToOne
    private DoctorDTO doctorDTO;

    @OneToOne
    private BookingDTO bookingDTO;
}
