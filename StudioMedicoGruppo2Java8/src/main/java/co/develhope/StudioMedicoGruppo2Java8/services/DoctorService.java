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
import co.develhope.StudioMedicoGruppo2Java8.utility.EmailSender;
import co.develhope.StudioMedicoGruppo2Java8.utility.StringUtility;
import it.pasqualecavallo.studentsmaterial.authorization_framework.utils.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private EmailSender emailSender;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;




    public DoctorResponseDTO register(DoctorRequestDTO request) {
        Doctor doctor = doctorRequestToEntity(request);
        doctorRepository.save(doctor);
        emailSender.sendRegistrationEmailDoctor(doctor);
        return doctorEntityToResponse(doctor);
    }

    public ActivateResponseDTO activate(ActivateRequestDTO request) {
        Optional<Doctor> oDoctor = doctorRepository.findByEmail(request.getEmail());
        Doctor doctor = oDoctor.orElseThrow(UserNotFoundException::new);
        if(request.getActivationCode().equals(doctor.getActivationCode())) {
            doctor.setActive(true);
            doctor.setActivationCode(null);
            doctorRepository.save(doctor);
            ActivateResponseDTO response = new ActivateResponseDTO();
            response.setStatus(Status.OK);
            response.setUsername(doctor.getUsername());
            return response;
        } else {
            throw new InvalidActivationCodeException();
        }
    }

    public List<DoctorResponseDTO> getDoctors(){
        return doctorEntitiesToResponses(doctorRepository.findAll());
    }


    public Optional<DoctorResponseDTO> getSingleDoctor(Long id){
        if(doctorRepository.existsById(id)){
            Optional<Doctor> doctor = doctorRepository.findById(id);
            return Optional.of(doctorEntityToResponse(doctor.get()));
        }else {
            throw new UserNotFoundException("Doctor not found");
        }
    }

    public DoctorResponseDTO editSingleDoctor(Long id,DoctorRequestDTO request){
        if(doctorRepository.existsById(id)){
            Optional<Doctor> doctor = doctorRepository.findById(id);
            doctorRepository.save(doctorRequestToEntity(request));
            return doctorEntityToResponse(doctor.get());
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
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setStatus(Status.OK);
        } else {
            throw new UserNotFoundException("Doctor not found");
        }
    }

    private Doctor doctorRequestToEntity(DoctorRequestDTO request){
        Doctor doctor = new Doctor();
        doctor.setName(request.getName());
        doctor.setSurname(request.getSurname());
        doctor.setPhoneNumber(request.getPhoneNumber());
        doctor.setEmail(request.getEmail());
        doctor.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        doctor.setUsername(request.getUsername());
        doctor.setActivationCode(StringUtility.generateRandomString(6));
        doctor.setPlaceOfWork(request.getPlaceOfWork());
        doctor.setDoctorSpecialization(request.getDoctorSpecialization());
        doctor.setWorkingDays(request.getWorkingDays());
        doctor.setSecretary(request.getSecretary());
        doctor.setCreatedOn(doctor.getCreatedOn());
        doctor.setModifiedOn(doctor.getModifiedOn());
        doctor.setCreatedBy(doctor.getUsername());
        doctor.setLastModifiedBy(doctor.getLastModifiedBy());
        doctor.setActive(false);
        doctor.setRecordStatus(RecordStatus.ACTIVE);
        return doctor;
    }

    public DoctorResponseDTO doctorEntityToResponse(Doctor doctor){
        DoctorResponseDTO response = new DoctorResponseDTO();
        response.setWorkingDays(doctor.getWorkingDays());
        response.setPlaceOfWork(doctor.getPlaceOfWork());
        response.setDoctorSpecialization(doctor.getDoctorSpecialization());
        response.setEmail(doctor.getEmail());
        response.setFirstName(doctor.getName());
        response.setLastName(doctor.getSurname());
        response.setPhoneNumber(doctor.getPhoneNumber());
        return response;
    }

    private List<DoctorResponseDTO> doctorEntitiesToResponses(List<Doctor> doctors) {
        List<DoctorResponseDTO> response = new ArrayList<>();
        for(Doctor doctor : doctors) {
            response.add(doctorEntityToResponse(doctor));
        }
        return response;
    }
}
