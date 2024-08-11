package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Farmer;
import com.app.entities.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {

<<<<<<< HEAD
	Optional<Merchant> findByEmail(String email);
	//derived query metho
=======
>>>>>>> 8ca407d31f1d0e6511aa7659dc3571b9ce854503
	boolean existsByEmail(String email);
}
