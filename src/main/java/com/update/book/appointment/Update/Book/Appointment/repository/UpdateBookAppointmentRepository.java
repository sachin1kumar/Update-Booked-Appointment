package com.update.book.appointment.Update.Book.Appointment.repository;

import com.update.book.appointment.Update.Book.Appointment.model.BookAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UpdateBookAppointmentRepository extends JpaRepository<BookAppointment, BigInteger> {
}
