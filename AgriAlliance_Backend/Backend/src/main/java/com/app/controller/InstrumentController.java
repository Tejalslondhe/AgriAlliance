package com.app.controller;

import com.app.dto.InstrumentDTO;
import com.app.entities.Instrument;
import com.app.services.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instruments")
public class InstrumentController {

    @Autowired
    private InstrumentService instrumentService;

    @PostMapping("/add")
    public Instrument addInstrument(@RequestBody InstrumentDTO instrumentDTO) {
        return instrumentService.addInstrument(instrumentDTO);
    }

    @GetMapping("/all")
    public List<Instrument> getAllInstruments() {
        return instrumentService.getAllInstruments();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteInstrument(@PathVariable Long id) {
        instrumentService.deleteInstrument(id);
    }
}
