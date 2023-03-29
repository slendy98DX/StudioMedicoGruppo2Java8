package co.develhope.StudioMedicoGruppo2Java8.services;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.entities.Secretary;
import co.develhope.StudioMedicoGruppo2Java8.enums.RecordStatus;
import co.develhope.StudioMedicoGruppo2Java8.repositories.BookingRepository;
import co.develhope.StudioMedicoGruppo2Java8.repositories.SecretaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecretaryService {

    @Autowired
    private SecretaryRepository secretaryRepository;

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private BookingService bookingService;


    public Secretary createSecretary(Secretary secretary) {
        secretary.setId(null);
        secretary.setRecordStatus(RecordStatus.ACTIVE);
        Secretary secretarySaved = secretaryRepository.saveAndFlush(secretary);
        return secretarySaved;
    }

    public List<Secretary> getAllSecretaries() {
        return secretaryRepository.findAll();
    }

    public Optional<Secretary> getSingleSecretary(Long id)throws Exception{
        if(secretaryRepository.existsById(id)){
            return secretaryRepository.findById(id);
        }else {
            throw new Exception("Secretary not found");
        }
    }

    public Secretary editSingleSecretary(Long id,Secretary secretary)throws Exception{
        if(secretaryRepository.existsById(id)){
            secretary.setId(id);
            return secretaryRepository.save(secretary);
        }else {
            throw new Exception("Secretary not found");
        }
    }

    public void deleteSingleSecretary(Long id) throws Exception {
        Optional<Secretary> secretary = secretaryRepository.findById(id);
        if(secretary.isPresent()){
            secretary.get().setId(id);
            secretary.get().setRecordStatus(RecordStatus.DELETED);
            secretaryRepository.save(secretary.get());
        } else {
            throw new Exception("secretary not found");
        }
    }

    public Booking createBooking(Booking booking) {
        return bookingService.createBooking(booking);
    }

    public List<Booking> getAllBookings(){
        return bookingService.getBookings();
    }

    public Optional<Booking> getSingleBooking(Long id)throws Exception{
        return bookingService.getSingleBooking(id);
    }

    public Booking editSingleBooking(Long id,Booking booking)throws Exception{
        return bookingService.editSingleBooking(id,booking);
    }

    public void deleteSingleBooking(Long id) throws Exception {
        bookingService.deleteSingleBooking(id);
    }
}
