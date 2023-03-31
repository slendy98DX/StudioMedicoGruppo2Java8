package co.develhope.StudioMedicoGruppo2Java8.enums;

public enum Status {

    OK("OK"),
    KO("KO")
    ;

    private final String status;

    public String getStatus() {
        return status;
    }

    Status(String status) {
        this.status = status;
    }

    public Status getRecordStatusFromValue(String value){
        Status statusValue = null;
        for (Status currentStatus : Status.values()) {
            if(currentStatus.getStatus().equals(value)){
                statusValue = currentStatus;
            }
        }
        return statusValue;
    }
}
