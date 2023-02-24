package co.develhope.StudioMedicoGruppo2Java8.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String bookingId;
    private LocalDate creationDate;
    private LocalDate bookingDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Doctor doctor;

    @OneToOne(fetch = FetchType.LAZY)
    private Patient patient;


}
