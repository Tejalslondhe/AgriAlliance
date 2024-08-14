package com.app.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Farmer;
import com.app.entities.Instrument;
import com.app.entities.InstrumentBooking;
import com.app.entities.User;
import com.app.services.BookingService;

@RestController
@RequestMapping("/bookings/f")
public class InstrumentBookingController {

	@Autowired
	private BookingService bookingService;
	
	private Farmer getFarmerById(Long userId) {
		return new Farmer();
	}
	
	private Instrument getInstrumentById(Long instrumentId) {
		return new Instrument();
	}
	
	@PostMapping
	public ResponseEntity<InstrumentBooking> bookInstrument(@RequestParam Long farmerId,@RequestParam Long instrumentId,@RequestParam String bookingDate,@RequestParam String returnDate){
		Farmer farmer=getFarmerById(farmerId);
		
		Instrument instrument=getInstrumentById(instrumentId);
		LocalDate bookingDateParsed = LocalDate.parse(bookingDate);
        LocalDate returnDateParsed = LocalDate.parse(returnDate);

        InstrumentBooking booking = bookingService.bookInstrument(farmer, instrument, bookingDateParsed, returnDateParsed);
        return ResponseEntity.ok(booking);
	}
	
	
}
