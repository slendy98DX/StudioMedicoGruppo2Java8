package co.develhope.StudioMedicoGruppo2Java8.controllers;


import co.develhope.StudioMedicoGruppo2Java8.entities.MedicalOffice;
import co.develhope.StudioMedicoGruppo2Java8.repositories.MedicalOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicaloffice")
public class MedicalOfficeController {

    @Autowired
    MedicalOfficeRepository medicalOfficeRepository;

    @PostMapping("")
    public MedicalOffice createMedicalOffice(@RequestBody MedicalOffice medicalOffice){
        medicalOffice.setMedicalOfficeId(null);
        MedicalOffice medicalOfficeSaved = medicalOfficeRepository.saveAndFlush(medicalOffice);
        return medicalOfficeSaved;
    }

    @GetMapping("")
    public List<MedicalOffice> getMedicaOffice(){
        return medicalOfficeRepository.findAll();
    }

}
