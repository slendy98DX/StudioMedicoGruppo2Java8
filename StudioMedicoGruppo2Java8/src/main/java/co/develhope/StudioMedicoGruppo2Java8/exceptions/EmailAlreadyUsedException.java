package co.develhope.StudioMedicoGruppo2Java8.exceptions;

public class EmailAlreadyUsedException extends RuntimeException{

    public EmailAlreadyUsedException() {
    }

    public EmailAlreadyUsedException(String message) {
        super(message);
    }

    public EmailAlreadyUsedException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailAlreadyUsedException(Throwable cause) {
        super(cause);
    }

    public EmailAlreadyUsedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
