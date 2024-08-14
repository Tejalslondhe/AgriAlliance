package com.app.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Farmer;
import com.app.entities.Instrument;
import com.app.entities.InstrumentBooking;
import com.app.entities.User;
import com.app.repository.FarmerRepository;
import com.app.repository.InstrumentRepository;
import com.app.repository.InstrumentsBookingRepository;
@Service
@Transactional
public class BookingServiceImpl implements BookingService {

	@Autowired
	private InstrumentsBookingRepository instruBookDao;
	
	@Autowired
	private InstrumentRepository instrumentRepository;
	
	@Autowired
	private FarmerRepository farmerRepository;
	

	
	@Override
	public InstrumentBooking bookInstrument(User user, Instrument instrument, LocalDate bookingDate,
			LocalDate returnDate) {
		
		InstrumentBooking booking= new InstrumentBooking();
		booking.setInstrument(instrument);
		booking.setBookingDate(bookingDate);
		booking.setReturnDate(returnDate);
		
		if(user instanceof Farmer) {
			booking.setFarmer((Farmer)user);
		}
		
		return instruBookDao.save(booking);
	}

}
