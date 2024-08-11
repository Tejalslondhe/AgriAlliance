package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Doctor;
import com.app.entities.Farmer;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

	boolean existsByEmail(String email);
<<<<<<< HEAD
	
	Optional<Doctor> findByEmail(String email);
	
=======
>>>>>>> 8ca407d31f1d0e6511aa7659dc3571b9ce854503
}
