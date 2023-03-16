package co.develhope.StudioMedicoGruppo2Java8.services;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.entities.Secretary;
import co.develhope.StudioMedicoGruppo2Java8.enums.RecordStatus;
import co.develhope.StudioMedicoGruppo2Java8.repositories.BookingRepository;
import co.develhope.StudioMedicoGruppo2Java8.repositories.SecretaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecretaryService {

    @Autowired
    private SecretaryRepository secretaryRepository;
    @Autowired
    private BookingRepository bookingRepository;


    public Secretary createSecretary(Secretary secretary) {
        secretary.setId(null);
        Secretary secretarySaved = secretaryRepository.saveAndFlush(secretary);
        return secretarySaved;
    }

    public List<Secretary> getAllSecretaries() {
        return secretaryRepository.findAll();
    }

    public Booking createBooking(Booking booking) {
        booking.setBookingId(null);
        Booking bookingSaved = bookingRepository.save(booking);
        return bookingSaved;
    }

    public List<Booking> getBookings(){
        return bookingRepository.findAll();
    }

    public Optional<Booking> getSingleBooking(Long id)throws Exception{
        if(bookingRepository.existsById(id)){
            return bookingRepository.findById(id);
        }else {
            throw new Exception("BookingDTO not found");
        }
    }

    public Booking editSingleBooking(Long id)throws Exception{
        Booking booking = new Booking();
        if(bookingRepository.existsById(id)){
            booking.setBookingId(id);
            return bookingRepository.save(booking);
        }else {
            throw new Exception("BookingDTO not found");
        }
    }

    public HttpStatus deleteSingleBooking(Long id){
        if (bookingRepository.existsById(id)){
            Booking booking = new Booking();
            booking.setBookingId(id);
            booking.setRecordStatus(RecordStatus.DELETED);
            return HttpStatus.ACCEPTED;
        }else {
            return HttpStatus.CONFLICT;
        }
    }

    public void deleteAllBooking(){
        bookingRepository.deleteAll();
    }
}
