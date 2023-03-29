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

    @GetMapping("/getSingleSecretary/{id}")
    public Optional<Secretary> getSingleSecretary(@PathVariable Long id) throws Exception {
        return secretaryService.getSingleSecretary(id);
    }

    @PutMapping("/updateSingleSecretary/{id}")
    public Secretary editSingleSecretary(@PathVariable Long id,@RequestBody Secretary secretary) throws Exception {
        return secretaryService.editSingleSecretary(id,secretary);
    }
    @PutMapping("/deleteSecretary/{id}")
    public void deleteSecretary(@PathVariable Long id) throws Exception {
        secretaryService.deleteSingleSecretary(id);
    }

    @PostMapping("/create-booking")
    public Booking createBooking(@RequestBody Booking booking){
        return secretaryService.createBooking(booking);
    }
    @GetMapping("/getAllBookings")
    public List<Booking> getAllBookings() {
        return secretaryService.getAllBookings();
    }
    @GetMapping("/getSingleBooking/{id}")
    public Optional<Booking> getSingleBooking(@PathVariable Long id) throws Exception {
        return secretaryService.getSingleBooking(id);
    }
    @PutMapping("/updateSingleBooking/{id}")
    public Booking updateSingleBooking(@PathVariable Long id,@RequestBody Booking booking) throws Exception {
        return secretaryService.editSingleBooking(id,booking);
    }
    @DeleteMapping("/deleteBooking/{id}")
    public void deleteBooking(@PathVariable Long id) throws Exception {
        secretaryService.deleteSingleBooking(id);
    }
}

