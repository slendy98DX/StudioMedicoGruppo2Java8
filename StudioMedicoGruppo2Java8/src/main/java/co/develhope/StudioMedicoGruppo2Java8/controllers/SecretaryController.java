package co.develhope.StudioMedicoGruppo2Java8.controllers;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.entities.Secretary;
import co.develhope.StudioMedicoGruppo2Java8.services.SecretaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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
    public Optional<Booking> getSingleBooking(@RequestParam Long id) throws Exception {
        return secretaryService.getSingleBooking(id);
    }
    @PutMapping("/updateSingleBooking")
    public Booking updateSingleBooking(@RequestParam Long id) throws Exception {
        return secretaryService.editSingleBooking(id);
    }
    @DeleteMapping("/deleteBooking/{id}")
    public void deleteBooking(@PathVariable Long id, Map<Object,Object> fields){
        secretaryService.deleteSingleBooking(id, fields);
    }
    @DeleteMapping("/deleteAllBooking")
    public void deleteAllBooking(){
        secretaryService.deleteAllBooking();
    }
}

