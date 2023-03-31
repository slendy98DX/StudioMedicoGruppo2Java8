package co.develhope.StudioMedicoGruppo2Java8.utility;

import co.develhope.StudioMedicoGruppo2Java8.entities.Doctor;
import co.develhope.StudioMedicoGruppo2Java8.entities.Patient;
import co.develhope.StudioMedicoGruppo2Java8.entities.Secretary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {

    @Autowired
    private JavaMailSender javaMailSender;


    @Value("${spring.mail.username}")
    private String mailFrom;

    public void sendRegistrationEmailDoctor(Doctor doctor) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailFrom);
        simpleMailMessage.setReplyTo(mailFrom);
        simpleMailMessage.setSubject("Registration completed");
        simpleMailMessage.setText("Ciao " + doctor.getUsername() + ", conferma la tua mail inserendo il codice: " + doctor.getActivationCode());
        simpleMailMessage.setTo(doctor.getEmail());
        javaMailSender.send(simpleMailMessage);
    }

    public void sendRegistrationEmailPatient(Patient patient) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailFrom);
        simpleMailMessage.setReplyTo(mailFrom);
        simpleMailMessage.setSubject("Registration completed");
        simpleMailMessage.setText("Ciao " + patient.getUsername() + ", conferma la tua mail inserendo il codice: " + patient.getActivationCode());
        simpleMailMessage.setTo(patient.getEmail());
        javaMailSender.send(simpleMailMessage);
    }

    public void sendRegistrationEmailSecretary(Secretary secretary) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailFrom);
        simpleMailMessage.setReplyTo(mailFrom);
        simpleMailMessage.setSubject("Registration completed");
        simpleMailMessage.setText("Ciao " + secretary.getUsername() + ", conferma la tua mail inserendo il codice: " + secretary.getActivationCode());
        simpleMailMessage.setTo(secretary.getEmail());
        javaMailSender.send(simpleMailMessage);
    }

}
