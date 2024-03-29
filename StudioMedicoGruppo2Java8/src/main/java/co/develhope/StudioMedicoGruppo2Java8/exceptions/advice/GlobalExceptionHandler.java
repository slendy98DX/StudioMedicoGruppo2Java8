package co.develhope.StudioMedicoGruppo2Java8.exceptions.advice;

import co.develhope.StudioMedicoGruppo2Java8.entities.dto.BaseResponse;
import co.develhope.StudioMedicoGruppo2Java8.enums.Status;
import co.develhope.StudioMedicoGruppo2Java8.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidActivationCodeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse handleInvalidActivationCodeException(InvalidActivationCodeException e) {
        BaseResponse br = new BaseResponse();
        br.setStatus(Status.KO);
        if(e.getMessage() != null) {
            br.setErrorMessage(e.getMessage());
        } else {
            br.setErrorMessage("INVALID_ACTIVATION_CODE");
        }
        return br;
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public BaseResponse handleUserNotFoundException(UserNotFoundException e) {
        BaseResponse br = new BaseResponse();
        br.setStatus(Status.KO);
        if(e.getMessage() != null) {
            br.setErrorMessage(e.getMessage());
        } else {
            br.setErrorMessage("USER_NOT_FOUND");
        }
        return br;
    }

    @ExceptionHandler(InvalidBookingDurationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse handleInvalidBookingDurationException(InvalidBookingDurationException e) {
        BaseResponse br = new BaseResponse();
        br.setStatus(Status.KO);
        if(e.getMessage() != null) {
            br.setErrorMessage(e.getMessage());
        } else {
            br.setErrorMessage("INVALID_BOOKING_DURATION");
        }
        return br;
    }
    @ExceptionHandler(BookingNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public BaseResponse handleBookingNotFoundException(BookingNotFoundException e) {
        BaseResponse br = new BaseResponse();
        br.setStatus(Status.KO);
        if(e.getMessage() != null) {
            br.setErrorMessage(e.getMessage());
        } else {
            br.setErrorMessage("BOOKING_NOT_FOUND");
        }
        return br;
    }

    @ExceptionHandler(InvalidBookingDateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse handleInvalidBookingDateException(InvalidBookingDateException e) {
        BaseResponse br = new BaseResponse();
        br.setStatus(Status.KO);
        if(e.getMessage() != null) {
            br.setErrorMessage(e.getMessage());
        } else {
            br.setErrorMessage("INVALID_BOOKING_DATE");
        }
        return br;
    }

    @ExceptionHandler(EmailAlreadyUsedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public BaseResponse handleInvalidBookingDateException(EmailAlreadyUsedException e) {
        BaseResponse br = new BaseResponse();
        br.setStatus(Status.KO);
        if(e.getMessage() != null) {
            br.setErrorMessage(e.getMessage());
        } else {
            br.setErrorMessage("EMAIL_ALREADY_USED");
        }
        return br;
    }
}
