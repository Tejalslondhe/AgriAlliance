package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
