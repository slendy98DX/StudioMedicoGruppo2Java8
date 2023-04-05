package co.develhope.StudioMedicoGruppo2Java8.controllers;

import co.develhope.StudioMedicoGruppo2Java8.entities.dto.BookingRequestDTO;
import co.develhope.StudioMedicoGruppo2Java8.entities.dto.BookingResponseDTO;
import co.develhope.StudioMedicoGruppo2Java8.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking")
    public BookingResponseDTO createBooking(@RequestBody BookingRequestDTO request){
        return bookingService.createBooking(request);
    }
}
