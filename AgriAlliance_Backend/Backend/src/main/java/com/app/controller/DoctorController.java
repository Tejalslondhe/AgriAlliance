package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DoctorDto;
import com.app.services.DoctorService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/doctors")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("/all")
	public List<DoctorDto> display()
	{
		return doctorService.displayAllDoctor();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id)
	{
		doctorService.deleteDoctor(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public DoctorDto update(@PathVariable Long id,@RequestBody DoctorDto doctor)
	{
		return doctorService.updateDoctor(id, doctor);
	}
	
	@PutMapping("/update/{email}")
    public ResponseEntity<DoctorDto> updateDoctorByEmail(
            @PathVariable String email,
            @RequestBody DoctorDto doctorDto) {
        DoctorDto updatedDoctor = doctorService.updateDoctorByEmail(email, doctorDto);
        return ResponseEntity.ok(updatedDoctor);
    }

    // Endpoint to delete a doctor by email
    @DeleteMapping("/delete/{email}")
    public ResponseEntity<Void> deleteDoctorByEmail(@PathVariable String email) {
        doctorService.deleteDoctorByEmail(email);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
