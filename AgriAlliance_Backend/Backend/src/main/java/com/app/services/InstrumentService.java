package com.app.services;

import com.app.dto.InstrumentDTO;
import com.app.entities.Instrument;
import com.app.repository.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentService {

    @Autowired
    private InstrumentRepository instrumentRepository;

    public Instrument addInstrument(InstrumentDTO instrumentDTO) {
        Instrument instrument = new Instrument();
        instrument.setName(instrumentDTO.getName());
        instrument.setType(instrumentDTO.getType());
        instrument.setAvailabilityStatus(instrumentDTO.isAvailabilityStatus());
        instrument.setRatePerDay(instrumentDTO.getRatePerDay());
        return instrumentRepository.save(instrument);
    }

    public List<Instrument> getAllInstruments() {
        return instrumentRepository.findAll();
    }

    public void deleteInstrument(Long id) {
        instrumentRepository.deleteById(id);
    }
}
