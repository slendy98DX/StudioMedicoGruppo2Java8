package co.develhope.StudioMedicoGruppo2Java8.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "medical_office")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalOffice {

    public enum MedicalOfficeType{
        SINGOLO,
        ASSOCIATO,
        AMBULATORIO,
        POLI_AMBULATORIO,
        POLIMEDICO,
    }
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String medicalOfficeId;
    private String address;
    private MedicalOfficeType medicalOfficeType;
}
