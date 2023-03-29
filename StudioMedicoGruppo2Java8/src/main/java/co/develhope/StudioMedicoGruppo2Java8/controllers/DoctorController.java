package co.develhope.StudioMedicoGruppo2Java8.controllers;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.entities.Doctor;
import co.develhope.StudioMedicoGruppo2Java8.services.DoctorService;
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

    @PostMapping("")
    public Doctor createDoctor(@RequestBody Doctor doctor){
        return doctorService.createDoctor(doctor);
    }
    @GetMapping("")
    public List<Doctor> getDoctors(){
        return doctorService.getDoctors();
    }

    @GetMapping("/getSingleDoctor/{id}")
    public Optional<Doctor> getSingleDoctor(@PathVariable Long id) throws Exception {
        return doctorService.getSingleDoctor(id);
    }

    @PutMapping("/updateSingleDoctor/{id}")
    public Doctor editSingleDoctor(@PathVariable Long id,@RequestBody Doctor doctor) throws Exception {
        return doctorService.editSingleDoctor(id,doctor);
    }
    @PutMapping("/deleteDoctor/{id}")
    public void deleteDoctor(@PathVariable Long id) throws Exception {
        doctorService.deleteSingleDoctor(id);
    }

    @GetMapping("/getBookingDate/{id}")
    public List<Booking> getSingleBooking(@RequestParam LocalDate localDate, @PathVariable Long id){
       return doctorService.getAllBookingByDate(localDate, id);
    }
}
