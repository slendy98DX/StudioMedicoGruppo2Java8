package co.develhope.StudioMedicoGruppo2Java8.controllers;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.entities.Secretary;
import co.develhope.StudioMedicoGruppo2Java8.entities.dto.ActivateRequestDTO;
import co.develhope.StudioMedicoGruppo2Java8.entities.dto.ActivateResponseDTO;
import co.develhope.StudioMedicoGruppo2Java8.entities.dto.SecretaryRequestDTO;
import co.develhope.StudioMedicoGruppo2Java8.entities.dto.SecretaryResponseDTO;
import co.develhope.StudioMedicoGruppo2Java8.services.SecretaryService;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.ZeroSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/secretary")
public class SecretaryController {

    @Autowired
    private SecretaryService secretaryService;




    @PostMapping("")
    @ZeroSecurity
    public SecretaryResponseDTO createSecretary(@RequestBody SecretaryRequestDTO request){
        return secretaryService.createSecretary(request);
    }

    @PostMapping("/activate")
    @RoleSecurity("ROLE_SECRETARY")
    public ActivateResponseDTO activate(@RequestBody ActivateRequestDTO request) {
        return secretaryService.activate(request);
    }
    @GetMapping("")
    @RoleSecurity("ROLE_SECRETARY")
    public List<Secretary> getAllSecretaries(){
        return secretaryService.getAllSecretaries();
    }

    @GetMapping("/getSingleSecretary/{id}")
    @RoleSecurity("ROLE_SECRETARY")
    public Optional<Secretary> getSingleSecretary(@PathVariable Long id) throws Exception {
        return secretaryService.getSingleSecretary(id);
    }

    @PutMapping("/updateSingleSecretary/{id}")
    @RoleSecurity("ROLE_SECRETARY")
    public Secretary editSingleSecretary(@PathVariable Long id,@RequestBody Secretary secretary){
        return secretaryService.editSingleSecretary(id,secretary);
    }
    @PutMapping("/deleteSecretary/{id}")
    @RoleSecurity("ROLE_SECRETARY")
    public void deleteSecretary(@PathVariable Long id){
        secretaryService.deleteSingleSecretary(id);
    }


}

