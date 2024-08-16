package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ApiException;
import com.app.custom_exception.InvalidCredentialsException;
import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.DoctorDto;
import com.app.dto.DoctorSignup;
import com.app.entities.Doctor;
import com.app.repository.DoctorRepository;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	@Override
	public DoctorSignup doctorRegistration(DoctorSignup reqDTO) {
	    Doctor doctor = mapper.map(reqDTO, Doctor.class);

	    if (doctorRepository.existsByEmail(reqDTO.getEmail())) {
	        throw new ApiException("Email already exists!");
	    }

	    doctor.setPassword(encoder.encode(doctor.getPassword()));
	    return mapper.map(doctorRepository.save(doctor), DoctorSignup.class);
	}

	@Override
	public List<DoctorDto> displayAllDoctor() {
		List<Doctor> doctors=doctorRepository.findAll();
		return doctors.stream().map(doctor->mapper.map(doctor, DoctorDto.class)).collect(Collectors.toList());

	}

	@Override
	public void deleteDoctor(Long id) {
		Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
		doctorRepository.delete(doctor);
	}

	@Override
	public DoctorDto updateDoctor(Long id, DoctorDto updateDoctor) {
		Doctor doctor=doctorRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Merchant not found with ID: " + id));
		
		mapper.map(updateDoctor, doctor);
		
		doctor=doctorRepository.save(doctor);
		
		return mapper.map(doctor, DoctorDto.class);
	}
	
	@Override
    public void deleteDoctorByEmail(String email) {
        Doctor doctor = doctorRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Doctor not found with email: " + email));
        doctorRepository.delete(doctor);
    }

    @Override
    public DoctorDto updateDoctorByEmail(String email, DoctorDto updateDoctor) {
        Doctor doctor = doctorRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Doctor not found with email: " + email));

        mapper.map(updateDoctor, doctor);
        doctor = doctorRepository.save(doctor);
        
        return mapper.map(doctor, DoctorDto.class);
    }

	
}
