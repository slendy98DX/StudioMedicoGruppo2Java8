package co.develhope.StudioMedicoGruppo2Java8.exceptions;

public class InvalidBookingDurationException extends RuntimeException{

    public InvalidBookingDurationException() {
    }

    public InvalidBookingDurationException(String message) {
        super(message);
    }

    public InvalidBookingDurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidBookingDurationException(Throwable cause) {
        super(cause);
    }

    public InvalidBookingDurationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
