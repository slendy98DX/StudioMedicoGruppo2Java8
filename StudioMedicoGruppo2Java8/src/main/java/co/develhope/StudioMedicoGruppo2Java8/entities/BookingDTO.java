package co.develhope.StudioMedicoGruppo2Java8.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking")
public class BookingDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookingId;
    private LocalDate creationDate;
    private LocalDate bookingDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private DoctorDTO doctorDTO;

    @OneToOne(fetch = FetchType.EAGER)
    private PatientDTO patientDTO;
}
