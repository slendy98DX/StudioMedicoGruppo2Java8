package co.develhope.StudioMedicoGruppo2Java8.controllers;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @PostMapping("")
    public Booking createBooking(@RequestBody Booking booking) {
        booking.setBookingId(null);
        Booking bookingSaved = bookingRepository.saveAndFlush(booking);
        return bookingSaved;
    }

    @GetMapping("")
    public List<Booking> getBookings(){
        return bookingRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Booking> getSingleBooking(@PathVariable String id)throws Exception{
        if(bookingRepository.existsById(id)){
            return bookingRepository.findById(id);
        }else {
            throw new Exception("Booking not found");
        }
    }

    @PutMapping("/{id}")
    public Booking editSingleBooking(@PathVariable String id, @RequestBody Booking booking)throws Exception{
        if(bookingRepository.existsById(id)){
            booking.setBookingId(id);
            return bookingRepository.saveAndFlush(booking);
        }else {
            throw new Exception("Booking not found");
        }
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteSingleBooking(@PathVariable String id){
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
