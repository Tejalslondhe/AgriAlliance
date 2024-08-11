package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

<<<<<<< HEAD
	Optional<Worker> findByEmail(String email);
	//derived query metho
=======
>>>>>>> 8ca407d31f1d0e6511aa7659dc3571b9ce854503
	boolean existsByEmail(String email);
}
