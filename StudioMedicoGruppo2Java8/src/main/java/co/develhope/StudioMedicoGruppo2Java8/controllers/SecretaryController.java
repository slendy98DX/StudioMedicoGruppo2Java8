package co.develhope.StudioMedicoGruppo2Java8.controllers;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.entities.Secretary;
import co.develhope.StudioMedicoGruppo2Java8.services.SecretaryService;
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
    public Secretary createSecretary(@RequestBody Secretary secretary){
        return secretaryService.createSecretary(secretary);
    }
    @GetMapping("")
    public List<Secretary> getAllSecretaries(){
        return secretaryService.getAllSecretaries();
    }
    @PostMapping("/create-booking")
    public Booking createBooking(@RequestBody Booking booking){
        return secretaryService.createBooking(booking);
    }
    @GetMapping("/getAllBookings")
    public List<Booking> getAllBookings() {
        return secretaryService.getBookings();
    }
    @GetMapping("/getSingleBooking")
    public Optional<Booking> getSingleBooking(Long id) throws Exception {
        return secretaryService.getSingleBooking(id);
    }
    @PutMapping("/updateSingleBooking")
    public Booking updateSingleBooking(Long id) throws Exception {
        return secretaryService.editSingleBooking(id);
    }
    @DeleteMapping("/deleteBooking")
    public void deleteBooking(Long id){
        secretaryService.deleteSingleBooking(id);
    }
    @DeleteMapping("/deleteAllBooking")
    public void deleteAllBooking(){
        secretaryService.deleteAllBooking();
    }
}

