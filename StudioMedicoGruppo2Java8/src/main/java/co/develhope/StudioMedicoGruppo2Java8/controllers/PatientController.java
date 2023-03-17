package co.develhope.StudioMedicoGruppo2Java8.controllers;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.entities.Patient;
import co.develhope.StudioMedicoGruppo2Java8.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;
    
    @PostMapping("")
    public Patient createPatient(@RequestBody Patient patient){
        return patientService.createPatient(patient);
    }

    @GetMapping("")
    public List<Patient> getPatients(){
        return patientService.getPatients();
    }
    @GetMapping("/getAllBooking")
    public List<Booking> getAllBooking(@RequestParam Long id) {
        return patientService.getAllBooking(id);
    }
    @PostMapping("/createBooking")
    public Booking createBooking(@RequestBody Booking booking) {
        return patientService.createBooking(booking);
    }
}
