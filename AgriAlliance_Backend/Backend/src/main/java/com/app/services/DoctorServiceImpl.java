package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ApiException;
import com.app.custom_exception.InvalidCredentialsException;
import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.DoctorDto;
import com.app.dto.DoctorSignup;
import com.app.entities.Doctor;
=======
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.InvalidCredentialsException;
import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.DoctorDto;
import com.app.dto.MerchantDto;
import com.app.entities.Doctor;
import com.app.entities.Merchant;
>>>>>>> 8ca407d31f1d0e6511aa7659dc3571b9ce854503
import com.app.repository.DoctorRepository;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorDao;
	
	@Autowired
	private ModelMapper mapper;
	
<<<<<<< HEAD
	@Autowired
	private PasswordEncoder encoder;
	
	
	@Override
	public DoctorSignup doctorRegistration(DoctorSignup reqDTO) {
	    Doctor doctor = mapper.map(reqDTO, Doctor.class);

	    if (doctorDao.existsByEmail(reqDTO.getEmail())) {
	        throw new ApiException("Email already exists!");
	    }

	    doctor.setPassword(encoder.encode(doctor.getPassword()));
	    return mapper.map(doctorDao.save(doctor), DoctorSignup.class);
	}

	
=======
>>>>>>> 8ca407d31f1d0e6511aa7659dc3571b9ce854503
	
	@Override
	public DoctorDto addNewDoctor(DoctorDto newDoctor) throws InvalidCredentialsException {
		Doctor doctor=mapper.map(newDoctor, Doctor.class);
		 if (doctor.getAddress() != null) {
			 doctor.getAddress().setId(null); // Ensures a new Address is created
	        } 
		 Doctor savedDoctor=doctorDao.save(doctor);
		 return mapper.map(savedDoctor, DoctorDto.class);	
	}

	@Override
	public List<DoctorDto> displayAllDoctor() {
		List<Doctor> doctors=doctorDao.findAll();
		return doctors.stream().map(doctor->mapper.map(doctor, DoctorDto.class)).collect(Collectors.toList());

	}

	@Override
	public void deleteDoctor(Long id) {
		Doctor doctor = doctorDao.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
		doctorDao.delete(doctor);
	}

	@Override
	public DoctorDto updateDoctor(Long id, DoctorDto updateDoctor) {
		Doctor doctor=doctorDao.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Merchant not found with ID: " + id));
		
		mapper.map(updateDoctor, doctor);
		
		doctor=doctorDao.save(doctor);
		
		return mapper.map(doctor, DoctorDto.class);
	}

	
}
