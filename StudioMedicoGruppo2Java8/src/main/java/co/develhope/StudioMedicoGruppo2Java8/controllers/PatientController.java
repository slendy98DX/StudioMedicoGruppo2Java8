package co.develhope.StudioMedicoGruppo2Java8.controllers;

import co.develhope.StudioMedicoGruppo2Java8.entities.BookingDTO;
import co.develhope.StudioMedicoGruppo2Java8.entities.PatientDTO;
import co.develhope.StudioMedicoGruppo2Java8.repositories.BookingRepository;
import co.develhope.StudioMedicoGruppo2Java8.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    BookingRepository bookingRepository;

    @PostMapping("")
    public PatientDTO createPatient(@RequestBody PatientDTO patientDTO){
        patientDTO.setPatientId(null);
        PatientDTO patientDTOSaved = patientRepository.saveAndFlush(patientDTO);
        return patientDTOSaved;
    }

    @GetMapping("")
    public List<PatientDTO> getPatients(){
        return patientRepository.findAll();
    }

    @PostMapping("/create-booking-patient")
    public BookingDTO createBooking(@RequestBody BookingDTO bookingDTO) {
        bookingDTO.setBookingId(null);
        BookingDTO bookingDTOSaved = bookingRepository.saveAndFlush(bookingDTO);
        return bookingDTOSaved;
    }
    @GetMapping("/read-booking-patient/{id}")
    public Optional<BookingDTO> findByPatientId(@PathVariable Long id) throws Exception {
        if(bookingRepository.existsById(id)){
            return bookingRepository.findById(id);
        }else {
            throw new Exception("Booking not found");
        }

    }
}
