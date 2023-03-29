package co.develhope.StudioMedicoGruppo2Java8.services;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.entities.Doctor;
import co.develhope.StudioMedicoGruppo2Java8.enums.RecordStatus;
import co.develhope.StudioMedicoGruppo2Java8.repositories.BookingRepository;
import co.develhope.StudioMedicoGruppo2Java8.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private BookingRepository bookingRepository;


    public Doctor createDoctor(Doctor doctor){
        doctor.setId(null);
        doctor.setRecordStatus(RecordStatus.ACTIVE);
        doctor.setCreatedBy(doctor.getEmail());
        Doctor doctorSaved = doctorRepository.saveAndFlush(doctor);
        return doctorSaved;
    }

    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getSingleDoctor(Long id)throws Exception{
        if(doctorRepository.existsById(id)){
            return doctorRepository.findById(id);
        }else {
            throw new Exception("Doctor not found");
        }
    }

    public Doctor editSingleDoctor(Long id,Doctor doctor)throws Exception{
        if(doctorRepository.existsById(id)){
            doctor.setId(id);
            return doctorRepository.save(doctor);
        }else {
            throw new Exception("Doctor not found");
        }
    }

    public void deleteSingleDoctor(Long id) throws Exception {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if(doctor.isPresent()){
            doctor.get().setId(id);
            doctor.get().setRecordStatus(RecordStatus.DELETED);
            doctorRepository.save(doctor.get());
        } else {
            throw new Exception("Doctor not found");
        }
    }


    public List<Booking> getAllBookingByDate(LocalDate localDate, Long id) {
        return bookingRepository.findAllByBookingDateAndDoctorId(localDate, id);
    }
}
