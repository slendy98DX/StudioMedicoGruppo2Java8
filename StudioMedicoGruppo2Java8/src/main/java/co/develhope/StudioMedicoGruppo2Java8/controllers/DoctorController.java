package co.develhope.StudioMedicoGruppo2Java8.controllers;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.entities.Doctor;
import co.develhope.StudioMedicoGruppo2Java8.entities.dto.ActivateRequestDTO;
import co.develhope.StudioMedicoGruppo2Java8.entities.dto.ActivateResponseDTO;
import co.develhope.StudioMedicoGruppo2Java8.entities.dto.DoctorRequestDTO;
import co.develhope.StudioMedicoGruppo2Java8.entities.dto.DoctorResponseDTO;
import co.develhope.StudioMedicoGruppo2Java8.services.DoctorService;
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
    @ZeroSecurity
    public DoctorResponseDTO createDoctor(@RequestBody DoctorRequestDTO request){
        return doctorService.register(request);
    }

    @PostMapping("/activate")
    @RoleSecurity("ROLE_DOCTOR")
    public ActivateResponseDTO activate(@RequestBody ActivateRequestDTO request) {
        return doctorService.activate(request);
    }

    @GetMapping("")
    @RoleSecurity("ROLE_SECRETARY")
    public List<Doctor> getDoctors(){
        return doctorService.getDoctors();
    }

    @GetMapping("/getSingleDoctor/{id}")
    @RoleSecurity("ROLE_SECRETARY")
    public Optional<Doctor> getSingleDoctor(@PathVariable Long id){
        return doctorService.getSingleDoctor(id);
    }

    @PutMapping("/updateSingleDoctor/{id}")
    @RoleSecurity("ROLE_SECRETARY")
    public Doctor editSingleDoctor(@PathVariable Long id,@RequestBody Doctor doctor){
        return doctorService.editSingleDoctor(id,doctor);
    }
    @PutMapping("/deleteDoctor/{id}")
    @RoleSecurity("ROLE_SECRETARY")
    public void deleteDoctor(@PathVariable Long id){
        doctorService.deleteSingleDoctor(id);
    }

    @GetMapping("/getBookingDate/{id}")
    @RoleSecurity("ROLE_DOCTOR")
    public List<Booking> getBookingsByDate(@RequestParam LocalDate localDate, @PathVariable Long id){
       return doctorService.getAllBookingByDate(localDate, id);
    }
}
