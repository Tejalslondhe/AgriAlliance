package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

	boolean findByEmail(String email);
}
