package com.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.custom_exception.InvalidCredentialsException;
import com.app.dto.FarmerSignup;
import com.app.dto.FarmerDto;

@Service
public interface FarmerService {

	// add signup method
	FarmerSignup farmerRegistration(FarmerSignup reqDTO);

	FarmerDto addNewFarmer(FarmerDto newFarmer) throws InvalidCredentialsException;

	List<FarmerDto> displayAllFarmers();

	void deleteFarmer(Long id);

	FarmerDto updateFarmer(Long farmerId, FarmerDto updateFarmer);

	FarmerDto getFarmerById(Long FarmerId);

}
