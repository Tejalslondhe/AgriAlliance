package com.app.services;

import java.util.List;
<<<<<<< HEAD
=======
import java.util.Optional;
>>>>>>> 8ca407d31f1d0e6511aa7659dc3571b9ce854503
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ApiException;
import com.app.custom_exception.InvalidCredentialsException;
import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.WorkerDto;
import com.app.dto.WorkerSignup;
=======
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.InvalidCredentialsException;
import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.UsersDTO;
import com.app.dto.WorkerDto;
import com.app.entities.User;
>>>>>>> 8ca407d31f1d0e6511aa7659dc3571b9ce854503
import com.app.entities.Worker;
import com.app.repository.WorkerRepository;

@Service
@Transactional
public class WorkerServiceImpl implements WorkerService {

	@Autowired
	private WorkerRepository workerDao;
	
	@Autowired
	private ModelMapper mapper;
<<<<<<< HEAD
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public WorkerSignup workerRegistration(WorkerSignup reqDTO) {
	    Worker worker = mapper.map(reqDTO, Worker.class);

	    if (workerDao.existsByEmail(reqDTO.getEmail())) {
	        throw new ApiException("Email already exists!");
	    }

	    worker.setPassword(encoder.encode(worker.getPassword()));
	    return mapper.map(workerDao.save(worker), WorkerSignup.class);
	}

=======
>>>>>>> 8ca407d31f1d0e6511aa7659dc3571b9ce854503

	@Override
	public WorkerDto addNewWorker(WorkerDto newWorker) throws InvalidCredentialsException {

		Worker worker=mapper.map(newWorker,Worker.class);
	     // Handling Address as a possible detached entity
	        if (worker.getAddress() != null) {
	        	worker.getAddress().setId(null); // Ensures a new Address is created
	        }
	       Worker savedWorker= workerDao.save(worker);
	        return mapper.map(savedWorker, WorkerDto.class);
		
	
	}

	@Override
	public List<WorkerDto> displayAllWorkers() {
		List<Worker> workers=workerDao.findAll();
		return workers.stream().map(worker->mapper.map(worker, WorkerDto.class)).collect(Collectors.toList());

	}

	@Override
	public void deleteWorker(Long id) {
		Worker worker = workerDao.findById(id).orElseThrow(() -> new RuntimeException("Worker not found"));
		workerDao.delete(worker);		
	}

	@Override
	public WorkerDto updateWorker(Long workerId, WorkerDto updateWorker) {
		Worker worker=workerDao.findById(workerId)
				.orElseThrow(()-> new ResourceNotFoundException("Worker not found with ID: " + workerId));
		
		mapper.map(updateWorker, worker);
		
		worker=workerDao.save(worker);
		
		return mapper.map(worker, WorkerDto.class);
	}

	@Override
	public WorkerDto getWorkerById(Long workerId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}
