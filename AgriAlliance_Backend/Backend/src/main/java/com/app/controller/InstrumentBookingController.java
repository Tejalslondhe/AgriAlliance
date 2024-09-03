package com.app.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.CrossOrigin;
=======
>>>>>>> 5c5619f252e31f143f79a6eac4c406433256a199
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.InstrumentBooking;
import com.app.services.BookingService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/bookings/f")
public class InstrumentBookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public InstrumentBooking bookInstrument(
            @RequestParam Long instrumentId,
<<<<<<< HEAD
            @RequestParam String farmeremail,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bookingDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate returnDate) {
        return bookingService.bookInstrument(instrumentId, farmeremail, bookingDate, returnDate);
=======
            @RequestParam Long farmerId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bookingDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate returnDate) {
        return bookingService.bookInstrument(instrumentId, farmerId, bookingDate, returnDate);
>>>>>>> 5c5619f252e31f143f79a6eac4c406433256a199
    }
}
