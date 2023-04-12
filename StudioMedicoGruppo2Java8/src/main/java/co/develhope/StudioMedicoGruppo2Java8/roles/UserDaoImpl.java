package co.develhope.StudioMedicoGruppo2Java8.roles;

import co.develhope.StudioMedicoGruppo2Java8.entities.Doctor;
import co.develhope.StudioMedicoGruppo2Java8.entities.Patient;
import co.develhope.StudioMedicoGruppo2Java8.entities.Secretary;
import co.develhope.StudioMedicoGruppo2Java8.repositories.DoctorRepository;
import co.develhope.StudioMedicoGruppo2Java8.repositories.PatientRepository;
import co.develhope.StudioMedicoGruppo2Java8.repositories.SecretaryRepository;
import it.pasqualecavallo.studentsmaterial.authorization_framework.dao.UserDao;
import it.pasqualecavallo.studentsmaterial.authorization_framework.service.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
public class UserDaoImpl implements UserDao {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private SecretaryRepository secretaryRepository;

    /**
     Retrieves the UserDetails object associated with the specified email address.
     The UserDetails object contains the username, password, and role(s) of the user.
     @param email the email address of the user
     @return the UserDetails object of the user, or null if no user was found with the specified email
     */
    @Override
    public UserDetails getUserByUsername(String email) {
        Optional<Patient> oPatient;
        Optional<Doctor> oDoctor;
        Optional<Secretary> oSecretary;
        if ((oPatient = patientRepository.findByEmail(email)).isPresent()) {
            UserDetails userDetails = new UserDetails();
            Patient patient = oPatient.get();
            userDetails.setUsername(patient.getEmail());
            userDetails.setPassword(patient.getPassword());
            userDetails.setRoles(Arrays.asList("ROLE_PATIENT"));
            return userDetails;
        } else if((oDoctor = doctorRepository.findByEmail(email)).isPresent()){
            UserDetails userDetails = new UserDetails();
            Doctor doctor = oDoctor.get();
            userDetails.setUsername(doctor.getEmail());
            userDetails.setPassword(doctor.getPassword());
            userDetails.setRoles(Arrays.asList("ROLE_DOCTOR"));
            return userDetails;
        } else if((oSecretary = secretaryRepository.findByEmail(email)).isPresent()) {
            UserDetails userDetails = new UserDetails();
            Secretary secretary = oSecretary.get();
            userDetails.setUsername(secretary.getEmail());
            userDetails.setPassword(secretary.getPassword());
            userDetails.setRoles(Arrays.asList("ROLE_SECRETARY"));
            return userDetails;
        } else{
            return null;
        }
    }
}
