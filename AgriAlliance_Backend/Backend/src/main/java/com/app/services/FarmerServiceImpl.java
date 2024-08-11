package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ApiException;
import com.app.custom_exception.InvalidCredentialsException;
import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.FarmerDto;
import com.app.dto.FarmerSignup;
import com.app.entities.Farmer;
import com.app.repository.FarmerRepository;

@Service
public class FarmerServiceImpl implements FarmerService {

	@Autowired
	private FarmerRepository farmerDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public FarmerSignup farmerRegistration(FarmerSignup reqDTO) {
		
		Farmer farmer = mapper.map(reqDTO,Farmer.class);
		
		if(farmerDao.existsByEmail(reqDTO.getEmail()))
			throw new ApiException("Email already exist !");
		
		farmer.setPassword(encoder.encode(farmer.getPassword()));
		return mapper.map(farmerDao.save(farmer), FarmerSignup.class);
	}


	@Override
	public List<FarmerDto> displayAllFarmers() {

		List<Farmer> farmer=farmerDao.findAll();
		return farmer.stream().map(user->mapper.map(user, FarmerDto.class)).collect(Collectors.toList());

	}

	@Override
	public void deleteFarmer(Long id) {
		  Farmer farmer = farmerDao.findById(id).orElseThrow(() -> new RuntimeException("Farmer not found"));
		  farmerDao.delete(farmer);
	}

	@Override
	public FarmerDto updateFarmer(Long farmerId, FarmerDto updateFarmer) {

		Farmer farmer=farmerDao.findById(farmerId)
				.orElseThrow(()-> new ResourceNotFoundException("Farmer not found with ID: " + farmerId));
		
		mapper.map(updateFarmer, farmer);
		
		farmer=farmerDao.save(farmer);
		
		return mapper.map(farmer, FarmerDto.class);
	
	}

	@Override
	public FarmerDto getFarmerById(Long farmerId) {
		Farmer farmer=farmerDao.findById(farmerId).orElseThrow(()-> new ResourceNotFoundException("Farmer not found"));
		
		return mapper.map(farmer, FarmerDto.class);
	}
	
	
	

}
