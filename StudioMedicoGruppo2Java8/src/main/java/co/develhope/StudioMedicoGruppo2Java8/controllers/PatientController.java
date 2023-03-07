package co.develhope.StudioMedicoGruppo2Java8.controllers;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.entities.Patient;
import co.develhope.StudioMedicoGruppo2Java8.repositories.BookingRepository;
import co.develhope.StudioMedicoGruppo2Java8.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    BookingRepository bookingRepository;

    @PostMapping("")
    public Patient createPatient(@RequestBody Patient patient){
        patient.setId(null);
        Patient patientSaved = patientRepository.saveAndFlush(patient);
        return patientSaved;
    }

    @GetMapping("")
    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }

    @PostMapping("/create-booking-patient")
    public Booking createBooking(@RequestBody Booking booking) {
        booking.setBookingId(null);
        Booking bookingSaved = bookingRepository.saveAndFlush(booking);
        return bookingSaved;
    }
    @GetMapping("/read-booking-patient/{id}")
    public Optional<Booking> findByPatientId(@PathVariable Long id) throws Exception {
        Patient patient = new Patient();
        if(patientRepository.existsById(id)){
            patient.setId(id);
            return bookingRepository.findByPatient(patient);
        }else {
            throw new Exception("Booking not found");
        }
    }
}
