package co.develhope.StudioMedicoGruppo2Java8.services;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.entities.Doctor;
import co.develhope.StudioMedicoGruppo2Java8.entities.Secretary;
import co.develhope.StudioMedicoGruppo2Java8.entities.dto.*;
import co.develhope.StudioMedicoGruppo2Java8.enums.RecordStatus;
import co.develhope.StudioMedicoGruppo2Java8.enums.Status;
import co.develhope.StudioMedicoGruppo2Java8.exceptions.InvalidActivationCodeException;
import co.develhope.StudioMedicoGruppo2Java8.exceptions.UserNotFoundException;
import co.develhope.StudioMedicoGruppo2Java8.repositories.BookingRepository;
import co.develhope.StudioMedicoGruppo2Java8.repositories.RoleRepository;
import co.develhope.StudioMedicoGruppo2Java8.repositories.SecretaryRepository;
import co.develhope.StudioMedicoGruppo2Java8.utility.EmailSender;
import co.develhope.StudioMedicoGruppo2Java8.utility.StringUtility;
import it.pasqualecavallo.studentsmaterial.authorization_framework.utils.BCryptPasswordEncoder;
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

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private EmailSender emailSender;


    public SecretaryResponseDTO createSecretary(SecretaryRequestDTO request) {
        Secretary secretary = secretaryRequestToEntity(request);
        secretaryRepository.save(secretary);
        emailSender.sendRegistrationEmailSecretary(secretary);
        return secretaryEntityToResponse();
    }

    public ActivateResponseDTO activate(ActivateRequestDTO request) {
        Optional<Secretary> oSecretary = secretaryRepository.findByEmail(request.getEmail());
        Secretary secretary = oSecretary.orElseThrow(UserNotFoundException::new);
        if(request.getActivationCode().equals(secretary.getActivationCode())) {
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

    public List<Secretary> getAllSecretaries() {
        return secretaryRepository.findAll();
    }

    public Optional<Secretary> getSingleSecretary(Long id){
        if(secretaryRepository.existsById(id)){
            return secretaryRepository.findById(id);
        }else {
            throw new UserNotFoundException("Secretary not found");
        }
    }

    public Secretary editSingleSecretary(Long id,Secretary secretary){
        if(secretaryRepository.existsById(id)){
            secretary.setId(id);
            return secretaryRepository.save(secretary);
        }else {
            throw new UserNotFoundException("Secretary not found");
        }
    }

    public void deleteSingleSecretary(Long id){
        Optional<Secretary> secretary = secretaryRepository.findById(id);
        if(secretary.isPresent()){
            secretary.get().setId(id);
            secretary.get().setRecordStatus(RecordStatus.DELETED);
            secretaryRepository.save(secretary.get());
        } else {
            throw new UserNotFoundException("Secretary not found");
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

    private Secretary secretaryRequestToEntity(SecretaryRequestDTO request){
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
        secretary.setRole(roleRepository.findByRoleName("ROLE_SECRETARY"));
        return secretary;
    }

    private SecretaryResponseDTO secretaryEntityToResponse(){
        SecretaryResponseDTO response = new SecretaryResponseDTO();
        response.setStatus(Status.OK);
        return response;
    }
}
