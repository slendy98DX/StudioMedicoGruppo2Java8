package co.develhope.StudioMedicoGruppo2Java8.entities.dto;

public class PatientResponseDTO extends PersonResponseDTO{

    private String taxIdCode;

    public String getTaxIdCode() {
        return taxIdCode;
    }

    public void setTaxIdCode(String taxIdCode) {
        this.taxIdCode = taxIdCode;
    }
}
