package co.develhope.StudioMedicoGruppo2Java8.services;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.entities.Doctor;
import co.develhope.StudioMedicoGruppo2Java8.entities.Patient;
import co.develhope.StudioMedicoGruppo2Java8.entities.dto.DoctorResponseDTO;
import co.develhope.StudioMedicoGruppo2Java8.enums.RecordStatus;
import co.develhope.StudioMedicoGruppo2Java8.repositories.BookingRepository;
import co.develhope.StudioMedicoGruppo2Java8.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingService bookingService;


    public Patient createPatient(Patient patient){
        patient.setId(null);
        patient.setRecordStatus(RecordStatus.ACTIVE);
        Patient patientSaved = patientRepository.save(patient);
        return patientSaved;
    }
    
    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }

    public Optional<Patient> getSinglePatient(Long id)throws Exception{
        if(patientRepository.existsById(id)){
            return patientRepository.findById(id);
        }else {
            throw new Exception("Patient not found");
        }
    }

    public Patient editSinglePatient(Long id, Patient patient)throws Exception{
        if(patientRepository.existsById(id)){
            patient.setId(id);
            return patientRepository.save(patient);
        }else {
            throw new Exception("Patient not found");
        }
    }

    public void deleteSinglePatient(Long id) throws Exception {
        Optional<Patient> patient = patientRepository.findById(id);
        if(patient.isPresent()){
            patient.get().setId(id);
            patient.get().setRecordStatus(RecordStatus.DELETED);
            patientRepository.save(patient.get());
        } else {
            throw new Exception("Patient not found");
        }
    }

    public Booking createBooking(Booking booking) {
        booking.setCreatedBy(booking.getPatient().getEmail());
        return bookingRepository.save(booking);
    }

    public void deleteSingleBooking(Long patientId, Long bookingId) throws Exception {
        Optional<Booking> booking = bookingRepository.findByPatientIdAndBookingId(patientId,bookingId);
        if(booking.isPresent() && booking.get().getRecordStatus().equals(RecordStatus.ACTIVE)){
            booking.get().setRecordStatus(RecordStatus.DELETED);
            bookingRepository.save(booking.get());
        } else {
            throw new Exception("Booking not found");
        }
    }

    public List<Booking> getAllActiveBooking(Long id,RecordStatus recordStatus) {
        return bookingRepository.findAllByPatientIdAndRecordStatus(id,recordStatus);
    }

    public PatientResponseDTO patientEntityToResponse(Patient patient){
        PatientResponseDTO response = new PatientResponseDTO();
        return response;
    }
}
