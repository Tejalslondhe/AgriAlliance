package com.app.services;

import java.time.LocalDate;

import com.app.entities.Instrument;
import com.app.entities.InstrumentBooking;
import com.app.entities.User;

public interface BookingService {
  InstrumentBooking bookInstrument(User user,Instrument instrument,LocalDate bookingDate,LocalDate returnDate);
}
