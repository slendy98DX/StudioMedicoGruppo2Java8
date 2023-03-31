package co.develhope.StudioMedicoGruppo2Java8.services;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.entities.Doctor;
import co.develhope.StudioMedicoGruppo2Java8.entities.dto.*;
import co.develhope.StudioMedicoGruppo2Java8.enums.RecordStatus;
import co.develhope.StudioMedicoGruppo2Java8.enums.Status;
import co.develhope.StudioMedicoGruppo2Java8.exceptions.InvalidActivationCodeException;
import co.develhope.StudioMedicoGruppo2Java8.exceptions.UserNotFoundException;
import co.develhope.StudioMedicoGruppo2Java8.repositories.BookingRepository;
import co.develhope.StudioMedicoGruppo2Java8.repositories.DoctorRepository;
import co.develhope.StudioMedicoGruppo2Java8.repositories.RoleRepository;
import co.develhope.StudioMedicoGruppo2Java8.utility.EmailSender;
import co.develhope.StudioMedicoGruppo2Java8.utility.StringUtility;
import it.pasqualecavallo.studentsmaterial.authorization_framework.utils.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private EmailSender emailSender;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleRepository roleRepository;


    public DoctorResponseDTO register(DoctorRequestDTO request) {
        Doctor doctor = doctorRequestToEntity(request);
        doctorRepository.save(doctor);
        emailSender.sendRegistrationEmailDoctor(doctor);
        return doctorEntityToResponse();
    }

    public ActivateResponseDto activate(ActivateRequestDto request) {
        Optional<Doctor> oDoctor = doctorRepository.findByEmail(request.getEmail());
        Doctor doctor = oDoctor.orElseThrow(UserNotFoundException::new);
        if(request.getActivationCode().equals(doctor.getActivationCode())) {
            doctor.setActive(true);
            doctor.setActivationCode(null);
            doctorRepository.save(doctor);
            ActivateResponseDto response = new ActivateResponseDto();
            response.setStatus(Status.OK);
            response.setUsername(doctor.getUsername());
            return response;
        } else {
            throw new InvalidActivationCodeException();
        }
    }

    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getSingleDoctor(Long id){
        if(doctorRepository.existsById(id)){
            return doctorRepository.findById(id);
        }else {
            throw new UserNotFoundException("Doctor not found");
        }
    }

    public Doctor editSingleDoctor(Long id,Doctor doctor){
        if(doctorRepository.existsById(id)){
            doctor.setId(id);
            return doctorRepository.save(doctor);
        }else {
            throw new UserNotFoundException("Doctor not found");
        }
    }

    public void deleteSingleDoctor(Long id){
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if(doctor.isPresent()){
            doctor.get().setId(id);
            doctor.get().setRecordStatus(RecordStatus.DELETED);
            doctorRepository.save(doctor.get());
        } else {
            throw new UserNotFoundException("Doctor not found");
        }
    }


    public List<Booking> getAllBookingByDate(LocalDate localDate, Long id) {
        return bookingRepository.findAllByBookingDateAndDoctorId(localDate, id);
    }

    private Doctor doctorRequestToEntity(DoctorRequestDTO request){
        Doctor doctor = new Doctor();
        doctor.setEmail(request.getEmail());
        doctor.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        doctor.setUsername(request.getUsername());
        doctor.setActivationCode(StringUtility.generateRandomString(6));
        doctor.setPlaceOfWork(request.getPlaceOfWork());
        doctor.setDoctorSpecialization(request.getDoctorSpecialization());
        doctor.setWorkingDays(request.getWorkingDays());
        doctor.setActive(false);
        doctor.setRole(roleRepository.findByRoleName("ROLE_DOCTOR"));
        return doctor;
    }

    private DoctorResponseDTO doctorEntityToResponse(){
        DoctorResponseDTO response = new DoctorResponseDTO();
        response.setStatus(Status.OK);
        return response;
    }
}
