package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.FarmerDto;
import com.app.dto.FarmerSignup;
import com.app.entities.Farmer;
import com.app.services.FarmerService;

@RestController
@RequestMapping("/farmers")
public class FarmerController {

	
	@Autowired
	private FarmerService farmerService;
		
	@GetMapping
	public List<FarmerDto> display()
	{
		return farmerService.displayAllFarmers();
	}
	
	@DeleteMapping("/{id}")
	public  ResponseEntity<Void> delete(@PathVariable Long id)
	{
		farmerService.deleteFarmer(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public FarmerDto update(@PathVariable Long id, @RequestBody FarmerDto farmerdto)
	{
		 return farmerService.updateFarmer(id, farmerdto);
	}
}
