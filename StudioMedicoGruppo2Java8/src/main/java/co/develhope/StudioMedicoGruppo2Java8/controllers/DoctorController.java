package co.develhope.StudioMedicoGruppo2Java8.controllers;

import co.develhope.StudioMedicoGruppo2Java8.entities.Doctor;
import co.develhope.StudioMedicoGruppo2Java8.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorRepository doctorRepository;

    @PostMapping("")
    public Doctor createDoctor(@RequestBody Doctor doctor){
        doctor.setDoctorId(null);
        Doctor doctorSaved = doctorRepository.saveAndFlush(doctor);
        return doctorSaved;
    }

    @GetMapping("")
    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }


}
