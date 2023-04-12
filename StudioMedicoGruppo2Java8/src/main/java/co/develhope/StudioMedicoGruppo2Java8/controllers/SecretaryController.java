package co.develhope.StudioMedicoGruppo2Java8.controllers;

import co.develhope.StudioMedicoGruppo2Java8.entities.Secretary;
import co.develhope.StudioMedicoGruppo2Java8.entities.dto.*;
import co.develhope.StudioMedicoGruppo2Java8.services.SecretaryService;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.PublicEndpoint;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/secretary")
public class SecretaryController {

    @Autowired
    private SecretaryService secretaryService;

    @PostMapping("/register")
    @PublicEndpoint
    public SecretaryResponseDTO createSecretary(@RequestBody SecretaryRequestDTO request){
        return secretaryService.createSecretary(request);
    }

    @PostMapping("/activate")
    @PublicEndpoint
    public ActivateResponseDTO activate(@RequestBody ActivateRequestDTO request) {
        return secretaryService.activate(request);
    }
    @GetMapping("/get-all-secretaries")
    @RoleSecurity("ROLE_SECRETARY")
    public List<SecretaryResponseDTO> getAllSecretaries(){
        return secretaryService.getAllSecretaries();
    }

    @GetMapping("/get-single-secretary/{id}")
    @RoleSecurity("ROLE_SECRETARY")
    public Optional<SecretaryResponseDTO> getSingleSecretary(@PathVariable Long id){
        return secretaryService.getSingleSecretary(id);
    }

    @PutMapping("/update-single-secretary/{id}")
    @RoleSecurity("ROLE_SECRETARY")
    public SecretaryResponseDTO editSingleSecretary(@PathVariable Long id,@RequestBody SecretaryRequestDTO request){
        return secretaryService.editSingleSecretary(id,request);
    }
    @PutMapping("/delete-secretary/{id}")
    @RoleSecurity("ROLE_SECRETARY")
    public void deleteSecretary(@PathVariable Long id){
        secretaryService.deleteSingleSecretary(id);
    }


}

