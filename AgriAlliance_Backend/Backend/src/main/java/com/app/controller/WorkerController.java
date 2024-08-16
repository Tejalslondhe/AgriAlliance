package com.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.WorkerDto;
import com.app.services.WorkerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/workers")
public class WorkerController {


		
		@Autowired
		private WorkerService workerService;
		
		@GetMapping("/all")
		public List<WorkerDto> display()
		{
			return workerService.displayAllWorkers();
		}
		
		@DeleteMapping("/delete/{id}")
		public  ResponseEntity<Void> delete(@PathVariable Long id)
		{
			workerService.deleteWorker(id);
			return ResponseEntity.noContent().build();
		}
		
		@PutMapping("/update/{id}")
		public WorkerDto update(@PathVariable Long id, @RequestBody WorkerDto workerDto)
		{
			return workerService.updateWorker(id,workerDto);
		}
		
		@PutMapping("/update/{email}")
	    public ResponseEntity<WorkerDto> updateWorkerByEmail(
	            @PathVariable String email,
	            @RequestBody WorkerDto workerDto) {
	        WorkerDto updatedWorker = workerService.updateWorkerByEmail(email, workerDto);
	        return ResponseEntity.ok(updatedWorker);
	    }

	    // Endpoint to delete a worker by email
	    @DeleteMapping("/delete/{email}")
	    public ResponseEntity<Void> deleteWorkerByEmail(@PathVariable String email) {
	        workerService.deleteWorkerByEmail(email);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}

