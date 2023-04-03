package co.develhope.StudioMedicoGruppo2Java8.exceptions;

public class InvalidActivationCodeException extends RuntimeException{

    public InvalidActivationCodeException() {
    }

    public InvalidActivationCodeException(String message) {
        super(message);
    }

    public InvalidActivationCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidActivationCodeException(Throwable cause) {
        super(cause);
    }

    public InvalidActivationCodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
