package co.develhope.StudioMedicoGruppo2Java8.controllers;

import co.develhope.StudioMedicoGruppo2Java8.entities.BookingDTO;
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
    public BookingDTO createBooking(@RequestBody BookingDTO bookingDTO) {
        bookingDTO.setBookingId(null);
        BookingDTO bookingDTOSaved = bookingRepository.saveAndFlush(bookingDTO);
        return bookingDTOSaved;
    }

    @GetMapping("")
    public List<BookingDTO> getBookings(){
        return bookingRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<BookingDTO> getSingleBooking(@PathVariable String id)throws Exception{
        if(bookingRepository.existsById(id)){
            return bookingRepository.findById(id);
        }else {
            throw new Exception("BookingDTO not found");
        }
    }

    @PutMapping("/{id}")
    public BookingDTO editSingleBooking(@PathVariable String id, @RequestBody BookingDTO bookingDTO)throws Exception{
        if(bookingRepository.existsById(id)){
            bookingDTO.setBookingId(id);
            return bookingRepository.saveAndFlush(bookingDTO);
        }else {
            throw new Exception("BookingDTO not found");
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
