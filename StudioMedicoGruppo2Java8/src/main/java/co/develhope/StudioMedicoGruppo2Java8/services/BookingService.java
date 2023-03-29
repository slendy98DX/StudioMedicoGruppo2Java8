package co.develhope.StudioMedicoGruppo2Java8.services;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.enums.RecordStatus;
import co.develhope.StudioMedicoGruppo2Java8.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        booking.setBookingId(null);
        booking.setRecordStatus(RecordStatus.ACTIVE);
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
            throw new Exception("Booking not found");
        }
    }

    public Booking editSingleBooking(Long id,Booking booking)throws Exception{
        if(bookingRepository.existsById(id)){
            booking.setBookingId(id);
            return bookingRepository.save(booking);
        }else {
            throw new Exception("Booking not found");
        }
    }

    public void deleteSingleBooking(Long id) throws Exception {
        Optional<Booking> booking = bookingRepository.findById(id);
        if(booking.isPresent()){
            booking.get().setBookingId(id);
            booking.get().setRecordStatus(RecordStatus.DELETED);
            bookingRepository.save(booking.get());
        } else {
            throw new Exception("Booking not found");
        }
    }
}
