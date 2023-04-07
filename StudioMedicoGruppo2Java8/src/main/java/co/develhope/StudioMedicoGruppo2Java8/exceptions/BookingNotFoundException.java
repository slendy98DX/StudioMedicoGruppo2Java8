package co.develhope.StudioMedicoGruppo2Java8.exceptions;

public class BookingNotFoundException extends RuntimeException{

    public BookingNotFoundException() {
    }

    public BookingNotFoundException(String message) {
        super(message);
    }

    public BookingNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookingNotFoundException(Throwable cause) {
        super(cause);
    }

    public BookingNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
