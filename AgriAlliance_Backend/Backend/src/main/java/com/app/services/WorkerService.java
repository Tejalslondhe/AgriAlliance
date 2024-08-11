package com.app.services;

import java.util.List;

import com.app.custom_exception.InvalidCredentialsException;
import com.app.dto.MerchantSignup;
import com.app.dto.WorkerDto;
import com.app.dto.WorkerSignup;

public interface WorkerService {
	
	WorkerSignup workerRegistration(WorkerSignup reqDTO);
	
	List<WorkerDto> displayAllWorkers();
	
	void deleteWorker(Long id);
	
	WorkerDto updateWorker(Long workerId, WorkerDto updateWorker);
	
	WorkerDto getWorkerById(Long workerId);
}
