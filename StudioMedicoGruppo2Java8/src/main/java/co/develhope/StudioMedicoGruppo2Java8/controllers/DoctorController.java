package co.develhope.StudioMedicoGruppo2Java8.controllers;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.entities.Doctor;
import co.develhope.StudioMedicoGruppo2Java8.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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

    @GetMapping("/getBookingDate")
    public List<Booking> getSingleBooking(@RequestParam LocalDate localDate, @RequestParam Long id){
       return doctorService.getAllBookingByDate(localDate, id);
    }
    @GetMapping("/getBookings")
    public List<Booking> getBookings(@RequestParam Long id) {
        return doctorService.getBookings(id);
    }
}
