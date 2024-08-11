package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Farmer;
import com.app.entities.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {


	Optional<Merchant> findByEmail(String email);
	//derived query metho

	boolean existsByEmail(String email);
}
