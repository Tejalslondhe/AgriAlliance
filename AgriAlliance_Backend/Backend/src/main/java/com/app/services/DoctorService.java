package com.app.services;

import java.util.List;

import com.app.custom_exception.InvalidCredentialsException;
import com.app.dto.DoctorDto;
import com.app.dto.DoctorSignup;

public interface DoctorService {

	DoctorSignup doctorRegistration(DoctorSignup reqDTO);
	
	DoctorDto addNewDoctor(DoctorDto newDoctor) throws InvalidCredentialsException;
	
	List<DoctorDto> displayAllDoctor();
	
	void deleteDoctor(Long id);
	
	DoctorDto updateDoctor(Long id,DoctorDto updateDoctor);
}
