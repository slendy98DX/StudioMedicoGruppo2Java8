package co.develhope.StudioMedicoGruppo2Java8.controllers;

import co.develhope.StudioMedicoGruppo2Java8.entities.SecretaryDTO;
import co.develhope.StudioMedicoGruppo2Java8.repositories.SecretaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secretary")
public class SecretaryController {

    @Autowired
    SecretaryRepository secretaryRepository;

    @PostMapping("")
    public SecretaryDTO createSecretary(@RequestBody SecretaryDTO secretaryDTO){
        secretaryDTO.setSecretaryId(null);
        SecretaryDTO secretaryDTOSaved = secretaryRepository.saveAndFlush(secretaryDTO);
        return secretaryDTOSaved;
    }

    @GetMapping("")
    public List<SecretaryDTO> getSecretary(){
        return secretaryRepository.findAll();
    }
}
