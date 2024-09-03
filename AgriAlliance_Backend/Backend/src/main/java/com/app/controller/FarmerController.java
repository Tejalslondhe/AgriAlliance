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

import com.app.dto.FarmerDto;
import com.app.services.FarmerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/farmers")
public class FarmerController {

	
	@Autowired
	private FarmerService farmerService;
		
	@GetMapping("/all")
	public List<FarmerDto> display()
	{
		return farmerService.displayAllFarmers();
	}
		
	
	@PutMapping("/update/{email}")
    public ResponseEntity<FarmerDto> updateFarmerByEmail(
            @PathVariable String email,
            @RequestBody FarmerDto farmerDto) {
        FarmerDto updatedFarmer = farmerService.updateFarmerByEmail(email, farmerDto);
        return ResponseEntity.ok(updatedFarmer);
    }

    // Endpoint to delete a farmer by email
    @DeleteMapping("/delete/{email}")
    public ResponseEntity<Void> deleteFarmerByEmail(@PathVariable String email) {
        farmerService.deleteFarmerByEmail(email);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
