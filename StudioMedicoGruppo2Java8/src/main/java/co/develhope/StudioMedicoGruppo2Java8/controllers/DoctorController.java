package co.develhope.StudioMedicoGruppo2Java8.controllers;

import co.develhope.StudioMedicoGruppo2Java8.entities.DoctorDTO;
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
    public DoctorDTO createDoctor(@RequestBody DoctorDTO doctorDTO){
        doctorDTO.setDoctorId(null);
        DoctorDTO doctorDTOSaved = doctorRepository.saveAndFlush(doctorDTO);
        return doctorDTOSaved;
    }

    @GetMapping("")
    public List<DoctorDTO> getDoctors(){
        return doctorRepository.findAll();
    }

}
