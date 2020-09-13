package com.update.book.appointment.Update.Book.Appointment.controller;

import com.update.book.appointment.Update.Book.Appointment.model.AppointmentResponse;
import com.update.book.appointment.Update.Book.Appointment.model.BookAppointment;
import com.update.book.appointment.Update.Book.Appointment.repository.UpdateBookAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/update-booked-appointment")
public class UpdateBookAppointmentController {

    @Autowired
    private UpdateBookAppointmentRepository updateBookAppointmentRepository;

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<AppointmentResponse> updateBookedAppointment(@RequestBody BookAppointment bookAppointment) {
        BookAppointment bookAppointmentDetails = updateBookAppointmentRepository.findById(bookAppointment.getBooking_id()).get();
        bookAppointmentDetails.setBooking_id(bookAppointment.getBooking_id());
        bookAppointmentDetails.setAppointment_date(bookAppointment.getAppointment_date());
        bookAppointmentDetails.setDoctor_id(bookAppointment.getDoctor_id());
        bookAppointmentDetails.setStatus(bookAppointment.getStatus());
        bookAppointmentDetails.setPatient_id(bookAppointment.getPatient_id());
        bookAppointmentDetails.setTime(bookAppointment.getTime());
        updateBookAppointmentRepository.save(bookAppointmentDetails);

        AppointmentResponse updatedResponse = new AppointmentResponse();
        updatedResponse.setBooking_id(bookAppointment.getBooking_id());
        updatedResponse.setAppointment_date(bookAppointment.getAppointment_date());
        updatedResponse.setStatus(bookAppointment.getStatus());
        updatedResponse.setTime(bookAppointment.getTime());

        return ResponseEntity.status(HttpStatus.CREATED).body(updatedResponse);
    }
}
