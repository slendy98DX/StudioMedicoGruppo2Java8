package co.develhope.StudioMedicoGruppo2Java8.exceptions;

public class InvalidBookingDateException extends RuntimeException{

    public InvalidBookingDateException() {
    }

    public InvalidBookingDateException(String message) {
        super(message);
    }

    public InvalidBookingDateException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidBookingDateException(Throwable cause) {
        super(cause);
    }

    public InvalidBookingDateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
