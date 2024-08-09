package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UsersDTO;
import com.app.dto.WorkerDto;
import com.app.entities.Worker;
import com.app.services.WorkerService;
@RestController
@RequestMapping("/workers")
public class WorkerController {


		
		@Autowired
		private WorkerService workerService;
		
		@PostMapping
		public WorkerDto add(@RequestBody WorkerDto workerDto)
		{
			return workerService.addNewWorker(workerDto);
		}
		
		@GetMapping
		public List<WorkerDto> display()
		{
			return workerService.displayAllWorkers();
		}
		
		@DeleteMapping("/{id}")
		public  ResponseEntity<Void> delete(@PathVariable Long id)
		{
			workerService.deleteWorker(id);
			return ResponseEntity.noContent().build();
		}
		
		@PutMapping("/{id}")
		public WorkerDto update(@PathVariable Long id, @RequestBody WorkerDto workerDto)
		{
			return workerService.updateWorker(id,workerDto);
		}
}

