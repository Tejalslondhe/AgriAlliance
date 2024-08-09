package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DoctorDto;
import com.app.services.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	
	@PostMapping
	public DoctorDto add(@RequestBody DoctorDto doctor)
	{
		return doctorService.addNewDoctor(doctor);
	}
	
	@GetMapping
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
}
