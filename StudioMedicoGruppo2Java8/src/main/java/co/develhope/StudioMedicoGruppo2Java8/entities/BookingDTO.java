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
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String bookingId;
    private LocalDate creationDate;
    private LocalDate bookingDate;

    @ManyToOne
    private DoctorDTO doctorDTO;
}
