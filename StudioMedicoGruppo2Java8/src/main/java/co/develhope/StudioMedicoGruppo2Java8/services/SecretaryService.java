package co.develhope.StudioMedicoGruppo2Java8.services;

import co.develhope.StudioMedicoGruppo2Java8.entities.Secretary;
import co.develhope.StudioMedicoGruppo2Java8.entities.dto.*;
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
public class SecretaryService {

    @Autowired
    private SecretaryRepository secretaryRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private EmailSender emailSender;


    public SecretaryResponseDTO createSecretary(SecretaryRequestDTO request) {
        if(patientRepository.findByEmail(request.getEmail()).isPresent() || doctorRepository.findByEmail(request.getEmail()).isPresent()){
            throw new EmailAlreadyUsedException("EMAIL_ALREADY_USED");
        } else {
            Secretary secretary = secretaryRequestToEntity(request);
            secretaryRepository.save(secretary);
            emailSender.sendRegistrationEmailSecretary(secretary);
            return secretaryEntityToResponse(secretary);
        }
    }

    public ActivateResponseDTO activate(ActivateRequestDTO request) {
        Optional<Secretary> oSecretary = secretaryRepository.findByEmail(request.getEmail());
        Secretary secretary = oSecretary.orElseThrow(UserNotFoundException::new);
        if (request.getActivationCode().equals(secretary.getActivationCode())) {
            secretary.setActive(true);
            secretary.setActivationCode(null);
            secretaryRepository.save(secretary);
            ActivateResponseDTO response = new ActivateResponseDTO();
            response.setStatus(Status.OK);
            response.setUsername(secretary.getUsername());
            return response;
        } else {
            throw new InvalidActivationCodeException();
        }
    }

    public List<SecretaryResponseDTO> getAllSecretaries() {
        return secretaryEntitiesToResponses(secretaryRepository.findAll());
    }

    public Optional<SecretaryResponseDTO> getSingleSecretary(Long id) {
        if (secretaryRepository.existsById(id)) {
            Optional<Secretary> secretary = secretaryRepository.findById(id);
            return Optional.of(secretaryEntityToResponse(secretary.get()));
        } else {
            throw new UserNotFoundException("Secretary not found");
        }
    }

    public SecretaryResponseDTO editSingleSecretary(Long id, SecretaryRequestDTO request) {
        if (secretaryRepository.existsById(id)) {
            Optional<Secretary> secretary = secretaryRepository.findById(id);
            secretaryRepository.save(secretaryRequestToEntity(request));
            return secretaryEntityToResponse(secretary.get());
        } else {
            throw new UserNotFoundException("Secretary not found");
        }
    }

    public void deleteSingleSecretary(Long id) {
        Optional<Secretary> secretary = secretaryRepository.findById(id);
        if (secretary.isPresent()) {
            secretary.get().setId(id);
            secretary.get().setRecordStatus(RecordStatus.DELETED);
            secretaryRepository.save(secretary.get());
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setStatus(Status.OK);
        } else {
            throw new UserNotFoundException("Secretary not found");
        }
    }

    private Secretary secretaryRequestToEntity(SecretaryRequestDTO request) {
        Secretary secretary = new Secretary();
        secretary.setName(request.getName());
        secretary.setSurname(request.getSurname());
        secretary.setPhoneNumber(request.getPhoneNumber());
        secretary.setEmail(request.getEmail());
        secretary.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        secretary.setUsername(request.getUsername());
        secretary.setActivationCode(StringUtility.generateRandomString(6));
        secretary.setWorkingDays(request.getWorkingDays());
        secretary.setCreatedOn(secretary.getCreatedOn());
        secretary.setModifiedOn(secretary.getModifiedOn());
        secretary.setCreatedBy(secretary.getUsername());
        secretary.setLastModifiedBy(secretary.getLastModifiedBy());
        secretary.setActive(false);
        secretary.setRecordStatus(RecordStatus.ACTIVE);
        return secretary;
    }

    private SecretaryResponseDTO secretaryEntityToResponse(Secretary secretary) {
        SecretaryResponseDTO response = new SecretaryResponseDTO();
        response.setWorkingDays(secretary.getWorkingDays());
        response.setEmail(secretary.getEmail());
        response.setFirstName(secretary.getName());
        response.setLastName(secretary.getSurname());
        response.setPhoneNumber(secretary.getPhoneNumber());
        return response;
    }

    private List<SecretaryResponseDTO> secretaryEntitiesToResponses(List<Secretary> secretaries) {
        List<SecretaryResponseDTO> response = new ArrayList<>();
        for (Secretary secretary : secretaries) {
            response.add(secretaryEntityToResponse(secretary));
        }
        return response;
    }
}
