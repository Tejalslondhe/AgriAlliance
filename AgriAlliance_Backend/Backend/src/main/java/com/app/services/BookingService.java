package com.app.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Farmer;
import com.app.entities.Instrument;
import com.app.entities.InstrumentBooking;
import com.app.repository.FarmerRepository;
import com.app.repository.InstrumentRepository;
import com.app.repository.InstrumentsBookingRepository;

@Service
public class BookingService {

    @Autowired
    private InstrumentsBookingRepository bookingRepository;

    @Autowired
    private InstrumentRepository instrumentRepository;

    @Autowired
    private FarmerRepository farmerRepository;

    public InstrumentBooking bookInstrument(Long instrumentId, Long farmerId, LocalDate bookingDate, LocalDate returnDate) {
        Optional<Instrument> instrumentOpt = instrumentRepository.findById(instrumentId);
        if (!instrumentOpt.isPresent()) {
            throw new RuntimeException("Instrument not found");
        }

        Optional<Farmer> farmerOpt = farmerRepository.findById(farmerId);
        if (!farmerOpt.isPresent()) {
            throw new RuntimeException("Farmer not found");
        }

        InstrumentBooking booking = new InstrumentBooking();
        booking.setInstrument(instrumentOpt.get());
        booking.setFarmer(farmerOpt.get());
        booking.setBookingDate(bookingDate);
        booking.setReturnDate(returnDate);

        return bookingRepository.save(booking);
    }
}
