package co.develhope.StudioMedicoGruppo2Java8.services;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.entities.Doctor;
import co.develhope.StudioMedicoGruppo2Java8.repositories.BookingRepository;
import co.develhope.StudioMedicoGruppo2Java8.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
        Doctor doctorSaved = doctorRepository.saveAndFlush(doctor);
        return doctorSaved;
    }

    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }


    public Optional<Booking> getSingleBooking(Long id)throws Exception{
        Doctor doctor = new Doctor();
        if(bookingRepository.existsById(id)){
            return bookingRepository.findByDoctor(doctor);
        }else {
            throw new Exception("BookingDTO not found");
        }
    }

    public List<Booking> getBookings() {
        Doctor doctor = new Doctor();
        return bookingRepository.findAllByDoctor(doctor);
    }
}
