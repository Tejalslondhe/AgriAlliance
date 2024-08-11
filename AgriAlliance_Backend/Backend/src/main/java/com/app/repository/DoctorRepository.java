package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Doctor;
import com.app.entities.Farmer;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

	boolean existsByEmail(String email);

	
	Optional<Doctor> findByEmail(String email);
	
}
