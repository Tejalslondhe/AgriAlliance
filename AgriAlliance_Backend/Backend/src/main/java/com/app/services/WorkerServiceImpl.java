package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ApiException;
import com.app.custom_exception.InvalidCredentialsException;
import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.WorkerDto;
import com.app.dto.WorkerSignup;
import com.app.entities.Worker;
import com.app.repository.WorkerRepository;

@Service
@Transactional
public class WorkerServiceImpl implements WorkerService {

	@Autowired
	private WorkerRepository workerRepository;
	
	@Autowired
	private ModelMapper mapper;

	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public WorkerSignup workerRegistration(WorkerSignup reqDTO) {
	    Worker worker = mapper.map(reqDTO, Worker.class);

	    if (workerRepository.existsByEmail(reqDTO.getEmail())) {
	        throw new ApiException("Email already exists!");
	    }

	    worker.setPassword(encoder.encode(worker.getPassword()));
	    return mapper.map(workerRepository.save(worker), WorkerSignup.class);
	}

	@Override
	public List<WorkerDto> displayAllWorkers() {
		List<Worker> workers=workerRepository.findAll();
		return workers.stream().map(worker->mapper.map(worker, WorkerDto.class)).collect(Collectors.toList());

	}

	@Override
	public void deleteWorker(Long id) {
		Worker worker = workerRepository.findById(id).orElseThrow(() -> new RuntimeException("Worker not found"));
		workerRepository.delete(worker);		
	}

	@Override
	public WorkerDto updateWorker(Long workerId, WorkerDto updateWorker) {
		Worker worker=workerRepository.findById(workerId)
				.orElseThrow(()-> new ResourceNotFoundException("Worker not found with ID: " + workerId));
		
		mapper.map(updateWorker, worker);
		
		worker=workerRepository.save(worker);
		
		return mapper.map(worker, WorkerDto.class);
	}

	
	
	@Override
    public void deleteWorkerByEmail(String email) {
        Worker worker = workerRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Worker not found with email: " + email));
        workerRepository.delete(worker);
    }

    @Override
    public WorkerDto updateWorkerByEmail(String email, WorkerDto updateWorker) {
        Worker worker = workerRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Worker not found with email: " + email));

        mapper.map(updateWorker, worker);
        worker = workerRepository.save(worker);
        
        return mapper.map(worker, WorkerDto.class);
    }
	
	

	
}
