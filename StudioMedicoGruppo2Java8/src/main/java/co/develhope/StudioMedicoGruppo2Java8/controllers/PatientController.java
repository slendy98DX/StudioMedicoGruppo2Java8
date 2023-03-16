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
    public Patient createPatient(Patient patient){
        return patientService.createPatient(patient);
    }

    @GetMapping("")
    public List<Patient> getPatients(){
        return patientService.getPatients();
    }
    @GetMapping("/getAllBooking")
    public List<Booking> getAllBooking() {
        return patientService.getAllBooking();
    }
    @PostMapping("/createBooking")
    public Booking createBooking(Booking booking) {
        return patientService.createBooking(booking);
    }
    @GetMapping("/getSingleBooking")
    public Optional<Booking> getSingleBooking(Long id) throws Exception {
        return patientService.getSingleBooking(id);
    }
    @DeleteMapping("/deleteBooking")
    public void deleteSingleBooking(Long id){
        patientService.deleteSingleBooking(id);
    }
}
