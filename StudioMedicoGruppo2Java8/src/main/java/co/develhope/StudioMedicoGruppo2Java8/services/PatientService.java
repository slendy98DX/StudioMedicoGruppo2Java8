package co.develhope.StudioMedicoGruppo2Java8.services;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.entities.Patient;
import co.develhope.StudioMedicoGruppo2Java8.enums.RecordStatus;
import co.develhope.StudioMedicoGruppo2Java8.repositories.BookingRepository;
import co.develhope.StudioMedicoGruppo2Java8.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

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

    public List<Booking> getAllBooking() {
        Patient patient = new Patient();
        return bookingRepository.findAllByPatient(patient);
    }
    public Booking createBooking(Booking booking) {
        booking.setBookingId(null);
        Booking bookingSaved = bookingRepository.save(booking);
        return bookingSaved;
    }
    public Optional<Booking> getSingleBooking(Long id) throws Exception {
        Patient patient = new Patient();
        if(patientRepository.existsById(id)){
            return bookingRepository.findByPatient(patient);
        }else {
            throw new Exception("Booking not found");
        }
    }
    public void deleteSingleBooking(Long id){
        Booking booking = new Booking();
        booking.setBookingId(id);
        booking.setRecordStatus(RecordStatus.DELETED);
    }
}
