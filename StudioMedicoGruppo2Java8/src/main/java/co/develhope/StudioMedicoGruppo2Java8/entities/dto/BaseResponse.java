package co.develhope.StudioMedicoGruppo2Java8.entities.dto;

import co.develhope.StudioMedicoGruppo2Java8.enums.Status;

public class BaseResponse {

    private Status status;
    private String errorMessage;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
