package co.develhope.StudioMedicoGruppo2Java8.services;

import co.develhope.StudioMedicoGruppo2Java8.entities.Booking;
import co.develhope.StudioMedicoGruppo2Java8.entities.dto.BaseResponse;
import co.develhope.StudioMedicoGruppo2Java8.entities.dto.BookingRequestDTO;
import co.develhope.StudioMedicoGruppo2Java8.entities.dto.BookingResponseDTO;
import co.develhope.StudioMedicoGruppo2Java8.enums.RecordStatus;
import co.develhope.StudioMedicoGruppo2Java8.enums.Status;
import co.develhope.StudioMedicoGruppo2Java8.exceptions.BookingNotFoundException;
import co.develhope.StudioMedicoGruppo2Java8.exceptions.InvalidBookingDurationException;
import co.develhope.StudioMedicoGruppo2Java8.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    public BookingResponseDTO postBooking(BookingRequestDTO request) {
        List<Booking> bookingList = bookingRepository.findByBookingDate(request.getBookingDate());
        int totalDuration = Integer.parseInt("1800");
        Booking booking;
        booking = bookingRequestToEntity(request);
        if (booking.getBookingDate().getMinute() == 30 || booking.getBookingDate().getMinute() == 00){
            for (Booking existingBooking : bookingList){
                totalDuration += existingBooking.getBookingDate().getSecond();
            }
            if(totalDuration + booking.getBookingDuration() > 1800){
                throw new InvalidBookingDurationException();
            }else{
                return bookingEntityToResponse(booking);
            }
        }else{
            throw new InvalidBookingDurationException();
        }
    }


    public List<BookingResponseDTO> getBookings(){
        return bookingEntitiesToResponses(bookingRepository.findAll());
    }



    public Optional<BookingResponseDTO> getSingleBooking(Long id){
        if(bookingRepository.existsById(id)){
            Optional<Booking> booking = bookingRepository.findById(id);
            return Optional.of(bookingEntityToResponse(booking.get()));
        }else {
            throw new BookingNotFoundException("Booking not found");
        }
    }

    public BookingResponseDTO editSingleBooking(Long id,BookingRequestDTO request){
        if(bookingRepository.existsById(id)){
            Optional<Booking> booking = bookingRepository.findById(id);
            bookingRepository.save(bookingRequestToEntity(request));
            return bookingEntityToResponse(booking.get());
        }else {
            throw new BookingNotFoundException("Booking not found");
        }
    }

    public void deleteSingleBooking(Long id){
        Optional<Booking> booking = bookingRepository.findById(id);
        if(booking.isPresent()){
            booking.get().setBookingId(id);
            booking.get().setRecordStatus(RecordStatus.DELETED);
            bookingRepository.save(booking.get());
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setStatus(Status.OK);
        } else {
            throw new BookingNotFoundException("Booking not found");
        }
    }
    public void deleteSingleBooking(Long patientId, Long bookingId){
        Optional<Booking> booking = bookingRepository.findByPatientIdAndBookingId(patientId,bookingId);
        if(booking.isPresent() && booking.get().getRecordStatus().equals(RecordStatus.ACTIVE)){
            booking.get().setRecordStatus(RecordStatus.DELETED);
            bookingRepository.save(booking.get());
        } else {
            throw new BookingNotFoundException("Booking not found");
        }
    }
    public List<BookingResponseDTO> getAllBookingByDate(LocalDate localDate, Long id) {
        return bookingRepository.findAllByBookingDateAndDoctorId(localDate, id);
    }

    public List<BookingResponseDTO> getAllActiveBooking(Long id,RecordStatus recordStatus) {
        return bookingRepository.findAllByPatientIdAndRecordStatus(id,recordStatus);
    }

    private Booking bookingRequestToEntity(BookingRequestDTO request){
        Booking booking = new Booking();
        booking.setBookingDate(request.getBookingDate());
        booking.setDoctor(request.getDoctor());
        booking.setPatient(request.getPatient());
        booking.setRecordStatus(RecordStatus.ACTIVE);
        booking.setCreatedOn(booking.getCreatedOn());
        booking.setModifiedOn(booking.getModifiedOn());
        return booking;
    }

    private BookingResponseDTO bookingEntityToResponse(Booking booking){
        BookingResponseDTO response = new BookingResponseDTO();
        response.setBookingDate(booking.getBookingDate());
        response.setPatient(patientService.patientEntityToResponse(booking.getPatient()));
        response.setDoctor(doctorService.doctorEntityToResponse(booking.getDoctor()));
        return response;
    }

    private List<BookingResponseDTO> bookingEntitiesToResponses(List<Booking> bookings) {
        List<BookingResponseDTO> response = new ArrayList<>();
        for(Booking booking : bookings) {
            response.add(bookingEntityToResponse(booking));
        }
        return response;
    }

}
