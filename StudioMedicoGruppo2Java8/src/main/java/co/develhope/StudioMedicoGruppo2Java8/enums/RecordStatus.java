package co.develhope.StudioMedicoGruppo2Java8.enums;

public enum RecordStatus {
    ACTIVE("A"),
    DELETED("D")

    ;

    private final String status;

    public String getStatus() {
        return status;
    }

    RecordStatus(String status) {
        this.status = status;
    }

    public RecordStatus getRecordStatusFromValue(String statusValue){
        RecordStatus recordStatus = null;
        for (RecordStatus currentStatus : RecordStatus.values()) {
            if(currentStatus.getStatus().equals(statusValue)){
                recordStatus = currentStatus;
            }
        }
        return recordStatus;
    }
}
