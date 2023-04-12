package co.develhope.StudioMedicoGruppo2Java8.services;


import co.develhope.StudioMedicoGruppo2Java8.entities.dto.*;
import co.develhope.StudioMedicoGruppo2Java8.entities.Patient;
import co.develhope.StudioMedicoGruppo2Java8.enums.RecordStatus;
import co.develhope.StudioMedicoGruppo2Java8.enums.Status;
import co.develhope.StudioMedicoGruppo2Java8.exceptions.EmailAlreadyUsedException;
import co.develhope.StudioMedicoGruppo2Java8.exceptions.InvalidActivationCodeException;
import co.develhope.StudioMedicoGruppo2Java8.exceptions.UserNotFoundException;
import co.develhope.StudioMedicoGruppo2Java8.repositories.DoctorRepository;
import co.develhope.StudioMedicoGruppo2Java8.repositories.PatientRepository;
import co.develhope.StudioMedicoGruppo2Java8.repositories.SecretaryRepository;
import co.develhope.StudioMedicoGruppo2Java8.utility.EmailSender;
import co.develhope.StudioMedicoGruppo2Java8.utility.StringUtility;
import it.pasqualecavallo.studentsmaterial.authorization_framework.utils.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private SecretaryRepository secretaryRepository;

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private EmailSender emailSender;


    public PatientResponseDTO register(PatientRequestDTO request) {
        if(doctorRepository.findByEmail(request.getEmail()).isPresent() || secretaryRepository.findByEmail(request.getEmail()).isPresent()){
            throw new EmailAlreadyUsedException("EMAIL_ALREADY_USED");
        } else {
            Patient patient = patientRequestToEntity(request);
            patientRepository.save(patient);
            emailSender.sendRegistrationEmailPatient(patient);
            return patientEntityToResponse(patient);
        }
    }

    public ActivateResponseDTO activate(ActivateRequestDTO request) {
        Optional<Patient> opatient = patientRepository.findByEmail(request.getEmail());
        Patient patient = opatient.orElseThrow(UserNotFoundException::new);
        if(request.getActivationCode().equals(patient.getActivationCode())) {
            patient.setActive(true);
            patient.setActivationCode(null);
            patientRepository.save(patient);
            ActivateResponseDTO response = new ActivateResponseDTO();
            response.setStatus(Status.OK);
            response.setUsername(patient.getUsername());
            return response;
        } else {
            throw new InvalidActivationCodeException();
        }
    }

    public List<PatientResponseDTO> getPatient(){
        return patientEntitiesToResponses(patientRepository.findAll());
    }


    public Optional<PatientResponseDTO> getSinglePatient(Long id){
        if(patientRepository.existsById(id)){
            Optional<Patient> patient = patientRepository.findById(id);
            return Optional.of(patientEntityToResponse(patient.get()));
        }else {
            throw new UserNotFoundException("patient not found");
        }
    }

    public PatientResponseDTO editSinglePatient(Long id,PatientRequestDTO request){
        if(patientRepository.existsById(id)){
            Optional<Patient> patient = patientRepository.findById(id);
            patientRepository.save(patientRequestToEntity(request));
            return patientEntityToResponse(patient.get());
        }else {
            throw new UserNotFoundException("patient not found");
        }
    }

    public void deleteSinglePatient(Long id){
        Optional<Patient> patient = patientRepository.findById(id);
        if(patient.isPresent()){
            patient.get().setId(id);
            patient.get().setRecordStatus(RecordStatus.DELETED);
            patientRepository.save(patient.get());
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setStatus(Status.OK);
        } else {
            throw new UserNotFoundException("patient not found");
        }
    }

    private Patient patientRequestToEntity(PatientRequestDTO request){
        Patient patient = new Patient();
        patient.setName(request.getName());
        patient.setSurname(request.getSurname());
        patient.setPhoneNumber(request.getPhoneNumber());
        patient.setEmail(request.getEmail());
        patient.setTaxIdCode(request.getTaxIdCode());
        patient.setDoctor(request.getDoctor());
        patient.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        patient.setUsername(request.getUsername());
        patient.setActivationCode(StringUtility.generateRandomString(6));
        patient.setCreatedOn(patient.getCreatedOn());
        patient.setModifiedOn(patient.getModifiedOn());
        patient.setCreatedBy(patient.getUsername());
        patient.setLastModifiedBy(patient.getLastModifiedBy());
        patient.setActive(false);
        patient.setRecordStatus(RecordStatus.ACTIVE);
        return patient;
    }

    public PatientResponseDTO patientEntityToResponse(Patient patient){
        PatientResponseDTO response = new PatientResponseDTO();
        response.setTaxIdCode(patient.getTaxIdCode());
        response.setEmail(patient.getEmail());
        response.setFirstName(patient.getName());
        response.setLastName(patient.getSurname());
        response.setPhoneNumber(patient.getPhoneNumber());
        return response;
    }

    private List<PatientResponseDTO> patientEntitiesToResponses(List<Patient> patients) {
        List<PatientResponseDTO> response = new ArrayList<>();
        for(Patient patient : patients) {
            response.add(patientEntityToResponse(patient));
        }
        return response;
    }
}
