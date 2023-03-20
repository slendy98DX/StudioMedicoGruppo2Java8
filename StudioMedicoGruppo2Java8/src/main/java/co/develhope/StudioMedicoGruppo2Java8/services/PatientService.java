package co.develhope.StudioMedicoGruppo2Java8.services;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.entities.Patient;
import co.develhope.StudioMedicoGruppo2Java8.repositories.BookingRepository;
import co.develhope.StudioMedicoGruppo2Java8.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private BookingRepository bookingRepository;


    public Patient createPatient(Patient patient){
        patient.setId(null);
        Patient patientSaved = patientRepository.saveAndFlush(patient);
        return patientSaved;
    }
    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }

    public List<Booking> getAllBooking(Long id) {
        return bookingRepository.findAllByPatientId(id);
    }
    public Booking createBooking(Booking booking) {
        booking.setBookingId(null);
        Booking bookingSaved = bookingRepository.save(booking);
        return bookingSaved;
    }
    /*public void deleteSingleBooking(Long id){
        Booking booking = new Booking();
        booking.setBookingId(id);
        booking.setRecordStatus(RecordStatus.DELETED);
    }*/
}
