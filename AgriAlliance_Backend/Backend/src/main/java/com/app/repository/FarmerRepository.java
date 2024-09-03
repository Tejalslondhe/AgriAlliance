package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Farmer;
import com.app.entities.PasswordResetToken;

public interface FarmerRepository extends JpaRepository<Farmer,Long>{
	
	//derived query metho
	boolean existsByEmail(String email);
	    
	Optional<Farmer> findByEmail(String email);

	
	void deleteByEmail(String email);
	
}
