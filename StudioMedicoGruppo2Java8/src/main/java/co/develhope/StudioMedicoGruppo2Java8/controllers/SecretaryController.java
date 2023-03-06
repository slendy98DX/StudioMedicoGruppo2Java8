package co.develhope.StudioMedicoGruppo2Java8.controllers;

import co.develhope.StudioMedicoGruppo2Java8.entities.BookingDTO;
import co.develhope.StudioMedicoGruppo2Java8.entities.SecretaryDTO;
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
    public SecretaryDTO createSecretary(@RequestBody SecretaryDTO secretaryDTO){
        secretaryDTO.setSecretaryId(null);
        SecretaryDTO secretaryDTOSaved = secretaryRepository.saveAndFlush(secretaryDTO);
        return secretaryDTOSaved;
    }

    @GetMapping("")
    public List<SecretaryDTO> getSecretary(){
        return secretaryRepository.findAll();
    }



    @PostMapping("/create-booking")
    public BookingDTO createBooking(@RequestBody BookingDTO bookingDTO) {
        bookingDTO.setBookingId(null);
        BookingDTO bookingDTOSaved = bookingRepository.saveAndFlush(bookingDTO);
        return bookingDTOSaved;
    }

    @GetMapping("/get-booking-list")
    public List<BookingDTO> getBookings(){
        return bookingRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<BookingDTO> getSingleBooking(@PathVariable Long id)throws Exception{
        if(bookingRepository.existsById(id)){
            return bookingRepository.findById(id);
        }else {
            throw new Exception("BookingDTO not found");
        }
    }

    @PutMapping("/{id}")
    public BookingDTO editSingleBooking(@PathVariable Long id, @RequestBody BookingDTO bookingDTO)throws Exception{
        if(bookingRepository.existsById(id)){
            bookingDTO.setBookingId(id);
            return bookingRepository.saveAndFlush(bookingDTO);
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

