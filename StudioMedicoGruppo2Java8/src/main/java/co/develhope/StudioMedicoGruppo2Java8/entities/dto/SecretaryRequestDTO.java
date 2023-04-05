package co.develhope.StudioMedicoGruppo2Java8.entities.dto;

public class SecretaryRequestDTO extends PersonRequestDTO {

    private Integer workingDays;

    public Integer getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(Integer workingDays) {
        this.workingDays = workingDays;
    }
}
