package co.develhope.StudioMedicoGruppo2Java8.controllers;

import co.develhope.StudioMedicoGruppo2Java8.entities.PatientDTO;
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
    public PatientDTO createPatient(@RequestBody PatientDTO patientDTO){
        patientDTO.setPatientId(null);
        PatientDTO patientDTOSaved = patientRepository.saveAndFlush(patientDTO);
        return patientDTOSaved;
    }

    @GetMapping("")
    public List<PatientDTO> getPatients(){
        return patientRepository.findAll();
    }
}
