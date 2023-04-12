package co.develhope.StudioMedicoGruppo2Java8.controllers;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.entities.Doctor;
import co.develhope.StudioMedicoGruppo2Java8.entities.dto.ActivateRequestDTO;
import co.develhope.StudioMedicoGruppo2Java8.entities.dto.ActivateResponseDTO;
import co.develhope.StudioMedicoGruppo2Java8.entities.dto.DoctorRequestDTO;
import co.develhope.StudioMedicoGruppo2Java8.entities.dto.DoctorResponseDTO;
import co.develhope.StudioMedicoGruppo2Java8.services.DoctorService;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.PublicEndpoint;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.ZeroSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/register")
    @PublicEndpoint
    public DoctorResponseDTO createDoctor(@RequestBody DoctorRequestDTO request){
        return doctorService.register(request);
    }

    @PostMapping("/activate")
    @PublicEndpoint
    public ActivateResponseDTO activate(@RequestBody ActivateRequestDTO request) {
        return doctorService.activate(request);
    }

    @GetMapping("/get-all-doctors")
    @RoleSecurity("ROLE_SECRETARY")
    public List<DoctorResponseDTO> getDoctors(){
        return doctorService.getDoctors();
    }

    @GetMapping("/get-single-doctor/{id}")
    @RoleSecurity("ROLE_SECRETARY")
    public Optional<DoctorResponseDTO> getSingleDoctor(@PathVariable Long id){
        return doctorService.getSingleDoctor(id);
    }

    @PutMapping("/update-single-doctor/{id}")
    @RoleSecurity("ROLE_SECRETARY")
    public DoctorResponseDTO editSingleDoctor(@PathVariable Long id,@RequestBody DoctorRequestDTO request){
        return doctorService.editSingleDoctor(id,request);
    }
    @PutMapping("/delete-doctor/{id}")
    @RoleSecurity("ROLE_SECRETARY")
    public void deleteDoctor(@PathVariable Long id){
        doctorService.deleteSingleDoctor(id);
    }

}
