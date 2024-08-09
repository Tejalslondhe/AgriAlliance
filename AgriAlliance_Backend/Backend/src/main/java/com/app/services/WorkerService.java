package com.app.services;

import java.util.List;

import com.app.custom_exception.InvalidCredentialsException;
import com.app.dto.UsersDTO;
import com.app.dto.WorkerDto;
import com.app.entities.Worker;

public interface WorkerService {

     WorkerDto addNewWorker (WorkerDto newWorker) throws InvalidCredentialsException;
	
	List<WorkerDto> displayAllWorkers();
	
	void deleteWorker(Long id);
	
	WorkerDto updateWorker(Long workerId, WorkerDto updateWorker);
	
	WorkerDto getWorkerById(Long workerId);
}
