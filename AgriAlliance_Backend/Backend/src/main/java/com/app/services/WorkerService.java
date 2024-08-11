package com.app.services;

import java.util.List;

import com.app.custom_exception.InvalidCredentialsException;
<<<<<<< HEAD
import com.app.dto.WorkerDto;
import com.app.dto.WorkerSignup;

public interface WorkerService {

	WorkerSignup workerRegistration(WorkerSignup reqDTO);

	WorkerDto addNewWorker(WorkerDto newWorker) throws InvalidCredentialsException;

	List<WorkerDto> displayAllWorkers();

	void deleteWorker(Long id);

	WorkerDto updateWorker(Long workerId, WorkerDto updateWorker);

=======
import com.app.dto.UsersDTO;
import com.app.dto.WorkerDto;
import com.app.entities.Worker;

public interface WorkerService {

     WorkerDto addNewWorker (WorkerDto newWorker) throws InvalidCredentialsException;
	
	List<WorkerDto> displayAllWorkers();
	
	void deleteWorker(Long id);
	
	WorkerDto updateWorker(Long workerId, WorkerDto updateWorker);
	
>>>>>>> 8ca407d31f1d0e6511aa7659dc3571b9ce854503
	WorkerDto getWorkerById(Long workerId);
}
