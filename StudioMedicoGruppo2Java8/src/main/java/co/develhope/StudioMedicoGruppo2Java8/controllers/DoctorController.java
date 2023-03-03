package co.develhope.StudioMedicoGruppo2Java8.controllers;

import co.develhope.StudioMedicoGruppo2Java8.entities.BookingDTO;
import co.develhope.StudioMedicoGruppo2Java8.entities.DoctorDTO;
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

    @PostMapping("/")
    public DoctorDTO createDoctor(@RequestBody DoctorDTO doctorDTO){
        doctorDTO.setDoctorId(null);
        DoctorDTO doctorDTOSaved = doctorRepository.saveAndFlush(doctorDTO);
        return doctorDTOSaved;
    }

    @GetMapping("/")
    public List<DoctorDTO> getDoctors(){
        return doctorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<BookingDTO> getSingleBooking(@PathVariable Long id)throws Exception{
        if(bookingRepository.existsById(id)){
            return bookingRepository.findById(id);
        }else {
            throw new Exception("BookingDTO not found");
        }
    }
    @GetMapping("/doctor-get-booking-list")
    public List<BookingDTO> getBookings(){
        return bookingRepository.findAll();
    }

}
