package co.develhope.StudioMedicoGruppo2Java8.enums;


public enum DoctorSpecialization{
    CARDIOLOGO("cardiologo"),
    ANDROLOGO("andrologo"),
    PODOLOGO("podologo"),
    GINECOLOGO("ginecologo"),
    UROLOGO("urologo"),
    PEDIATRA("pediatria")

    ;

    private final String name;

    public String getStatus() {
        return name;
    }

    DoctorSpecialization(String name) {
        this.name = name;
    }

    public DoctorSpecialization getDoctorSpecializationFromName(String nameValue){
        DoctorSpecialization doctorSpecialization = null;
        for (DoctorSpecialization currentName : DoctorSpecialization.values()) {
            if(currentName.getStatus().equals(nameValue)){
                doctorSpecialization = currentName;
            }
        }
        return doctorSpecialization;
    }
}
