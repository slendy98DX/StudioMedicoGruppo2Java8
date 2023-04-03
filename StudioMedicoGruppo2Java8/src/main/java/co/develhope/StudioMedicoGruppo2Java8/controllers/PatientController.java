package co.develhope.StudioMedicoGruppo2Java8.controllers;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.entities.Patient;
import co.develhope.StudioMedicoGruppo2Java8.enums.RecordStatus;
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
    
    @PostMapping("/create-patient")
    public Patient createPatient(@RequestBody Patient patient){
        return patientService.createPatient(patient);
    }

    @GetMapping("/get-all-patients")
    public List<Patient> getPatients(){
        return patientService.getPatients();
    }

    @GetMapping("/get-single-patient/{id}")
    public Optional<Patient> getSinglePatient(@PathVariable Long id) throws Exception {
        return patientService.getSinglePatient(id);
    }

    @PutMapping("/update-single-patient/{id}")
    public Patient editSinglePatient(@PathVariable Long id,@RequestBody Patient patient) throws Exception {
        return patientService.editSinglePatient(id,patient);
    }
    @PutMapping("/delete-patient/{id}")
    public void deletePatient(@PathVariable Long id) throws Exception {
        patientService.deleteSinglePatient(id);
    }
    @PostMapping("/createBooking")
    public Booking createBooking(@RequestBody Booking booking) {
        return patientService.createBooking(booking);
    }
    @GetMapping("/getAllBooking/{id}")
    public List<Booking> getAllActiveBookings(@PathVariable Long id, @RequestParam RecordStatus recordStatus) {
        return patientService.getAllActiveBooking(id,recordStatus);
    }

    @DeleteMapping("/deleteBooking/{patientId}/{bookingId}")
    public void deleteBooking(@PathVariable Long patientId, @PathVariable Long bookingId) throws Exception {
        patientService.deleteSingleBooking(patientId,bookingId);
    }
}
