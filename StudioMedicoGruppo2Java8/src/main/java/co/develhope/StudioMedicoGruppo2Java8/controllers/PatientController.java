package co.develhope.StudioMedicoGruppo2Java8.controllers;

import co.develhope.StudioMedicoGruppo2Java8.entities.Doctor;
import co.develhope.StudioMedicoGruppo2Java8.entities.Patient;
import co.develhope.StudioMedicoGruppo2Java8.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @PostMapping("")
    public Patient createPatient(@RequestBody Patient patient){
        patient.setPatientId(null);
        Patient patientSaved = patientRepository.saveAndFlush(patient);
        return patientSaved;
    }

    @GetMapping("")
    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }
}
