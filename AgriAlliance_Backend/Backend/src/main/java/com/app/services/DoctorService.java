package com.app.services;

import java.util.List;

import com.app.custom_exception.InvalidCredentialsException;
import com.app.dto.DoctorDto;
<<<<<<< HEAD
import com.app.dto.DoctorSignup;

public interface DoctorService {

	DoctorSignup doctorRegistration(DoctorSignup reqDTO);
	
	DoctorDto addNewDoctor(DoctorDto newDoctor) throws InvalidCredentialsException;
=======

public interface DoctorService {
DoctorDto addNewDoctor(DoctorDto newDoctor) throws InvalidCredentialsException;
>>>>>>> 8ca407d31f1d0e6511aa7659dc3571b9ce854503
	
	List<DoctorDto> displayAllDoctor();
	
	void deleteDoctor(Long id);
	
	DoctorDto updateDoctor(Long id,DoctorDto updateDoctor);
}
