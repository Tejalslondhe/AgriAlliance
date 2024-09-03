package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Farmer;
import com.app.entities.User;

public interface UserRepository extends JpaRepository<Farmer, Long> {
	Optional<Farmer> findByEmail(String email);

}
