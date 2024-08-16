package com.app.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
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
            @RequestParam String farmeremail,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bookingDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate returnDate) {
        return bookingService.bookInstrument(instrumentId, farmeremail, bookingDate, returnDate);
    }
}
