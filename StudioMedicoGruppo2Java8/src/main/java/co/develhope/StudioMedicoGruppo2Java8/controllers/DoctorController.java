package co.develhope.StudioMedicoGruppo2Java8.controllers;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.entities.Doctor;
import co.develhope.StudioMedicoGruppo2Java8.repositories.BookingRepository;
import co.develhope.StudioMedicoGruppo2Java8.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    BookingRepository bookingRepository;

    @PostMapping("")
    public Doctor createDoctor(@RequestBody Doctor doctor){
        doctor.setDoctorId(null);
        Doctor doctorSaved = doctorRepository.saveAndFlush(doctor);
        return doctorSaved;
    }

    @GetMapping("")
    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Booking> getSingleBooking(@PathVariable Long id)throws Exception{
        if(bookingRepository.existsById(id)){
            return bookingRepository.findById(id);
        }else {
            throw new Exception("BookingDTO not found");
        }
    }
    @GetMapping("/doctor-get-booking-list")
    public List<Booking> getBookings(){
        return bookingRepository.findAll();
    }

}
