package co.develhope.StudioMedicoGruppo2Java8.controllers;

import co.develhope.StudioMedicoGruppo2Java8.entities.dto.BookingRequestDTO;
import co.develhope.StudioMedicoGruppo2Java8.entities.dto.BookingResponseDTO;
import co.develhope.StudioMedicoGruppo2Java8.enums.RecordStatus;
import co.develhope.StudioMedicoGruppo2Java8.services.BookingService;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking")
    @RoleSecurity({"ROLE_SECRETARY","ROLE_PATIENT"})
    public BookingResponseDTO createBooking(@RequestBody BookingRequestDTO request){
        return bookingService.postBooking(request);
    }
    @GetMapping("/getAllBookings")
    @RoleSecurity("ROLE_SECRETARY")
    public List<BookingResponseDTO> getAllBookings() {
        return bookingService.getBookings();
    }
    @GetMapping("/getSingleBooking/{id}")
    @RoleSecurity("ROLE_SECRETARY")
    public Optional<BookingResponseDTO> getSingleBooking(@PathVariable Long id){
        return bookingService.getSingleBooking(id);
    }
    @PutMapping("/updateSingleBooking/{id}")
    @RoleSecurity("ROLE_SECRETARY")
    public BookingResponseDTO updateSingleBooking(@PathVariable Long id, @RequestBody BookingRequestDTO request){
        return bookingService.editSingleBooking(id,request);
    }
    @DeleteMapping("/deleteBooking/{id}")
    @RoleSecurity("ROLE_SECRETARY")
    public void deleteBooking(@PathVariable Long id){
        bookingService.deleteSingleBooking(id);
    }

    @GetMapping("/getBookingDate/{id}")
    @RoleSecurity("ROLE_DOCTOR")
    public List<BookingResponseDTO> getBookingsByDate(@RequestParam LocalDate localDate, @PathVariable Long id){
        return bookingService.getAllBookingByDate(localDate, id);
    }

    @DeleteMapping("/deleteBooking/{patientId}/{bookingId}")
    @RoleSecurity("ROLE_PATIENT")
    public void deleteBooking(@PathVariable Long patientId, @PathVariable Long bookingId){
        bookingService.deleteSingleBooking(patientId,bookingId);
    }

    @GetMapping("/getAllBooking/{id}")
    @RoleSecurity("ROLE_PATIENT")
    public List<BookingResponseDTO> getAllActiveBookings(@PathVariable Long id, @RequestParam RecordStatus recordStatus) {
        return bookingService.getAllActiveBooking(id,recordStatus);
    }
}
