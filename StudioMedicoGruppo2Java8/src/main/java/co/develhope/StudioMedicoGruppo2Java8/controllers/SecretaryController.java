package co.develhope.StudioMedicoGruppo2Java8.controllers;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.entities.Secretary;
import co.develhope.StudioMedicoGruppo2Java8.repositories.BookingRepository;
import co.develhope.StudioMedicoGruppo2Java8.repositories.SecretaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/secretary")
public class SecretaryController {

    @Autowired
    SecretaryRepository secretaryRepository;
    @Autowired
    BookingRepository bookingRepository;


    @PostMapping("")
    public Secretary createSecretary(@RequestBody Secretary secretary){
        secretary.setSecretaryId(null);
        Secretary secretarySaved = secretaryRepository.saveAndFlush(secretary);
        return secretarySaved;
    }

    @GetMapping("")
    public List<Secretary> getSecretary(){
        return secretaryRepository.findAll();
    }



    @PostMapping("/create-booking")
    public Booking createBooking(@RequestBody Booking booking) {
        booking.setBookingId(null);
        Booking bookingSaved = bookingRepository.saveAndFlush(booking);
        return bookingSaved;
    }

    @GetMapping("/get-booking-list")
    public List<Booking> getBookings(){
        return bookingRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Booking> getSingleBooking(@PathVariable Long id)throws Exception{
        if(bookingRepository.existsById(id)){
            return bookingRepository.findById(id);
        }else {
            throw new Exception("BookingDTO not found");
        }
    }

    @PutMapping("/{id}")
    public Booking editSingleBooking(@PathVariable Long id, @RequestBody Booking booking)throws Exception{
        if(bookingRepository.existsById(id)){
            booking.setBookingId(id);
            return bookingRepository.saveAndFlush(booking);
        }else {
            throw new Exception("BookingDTO not found");
        }
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteSingleBooking(@PathVariable Long id){
        if (bookingRepository.existsById(id)){
            bookingRepository.deleteById(id);
            return HttpStatus.ACCEPTED;
        }else {
            return HttpStatus.CONFLICT;
        }
    }

    @DeleteMapping("")
    public void deleteAllBooking(){
        bookingRepository.deleteAll();
    }
}

