package co.develhope.StudioMedicoGruppo2Java8.controllers;

import co.develhope.StudioMedicoGruppo2Java8.entities.dto.ActivateRequestDTO;
import co.develhope.StudioMedicoGruppo2Java8.entities.dto.ActivateResponseDTO;
import co.develhope.StudioMedicoGruppo2Java8.entities.dto.PatientRequestDTO;
import co.develhope.StudioMedicoGruppo2Java8.entities.dto.PatientResponseDTO;
import co.develhope.StudioMedicoGruppo2Java8.services.PatientService;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;
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
    public PatientResponseDTO register(@RequestBody PatientRequestDTO request){
        return patientService.register(request);
    }

    @PostMapping("/activate")
    @RoleSecurity("ROLE_PATIENT")
    public ActivateResponseDTO activate(@RequestBody ActivateRequestDTO request) {
        return patientService.activate(request);
    }

    @GetMapping("/get-all-patients")
    public List<PatientResponseDTO> getPatient(){
        return patientService.getPatient();
    }

    @GetMapping("/get-single-patient/{id}")
    public Optional<PatientResponseDTO> getSinglePatient(@PathVariable Long id) throws Exception {
        return patientService.getSinglePatient(id);
    }

    @PutMapping("/update-single-patient/{id}")
    public PatientResponseDTO editSinglePatient(@PathVariable Long id, @RequestBody PatientRequestDTO request) throws Exception {
        return patientService.editSinglePatient(id,request);
    }
    @PutMapping("/delete-patient/{id}")
    public void deletePatient(@PathVariable Long id) throws Exception {
        patientService.deleteSinglePatient(id);
    }
}
