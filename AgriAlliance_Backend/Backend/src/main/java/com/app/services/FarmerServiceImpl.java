package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ApiException;
import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.FarmerDto;
import com.app.dto.FarmerSignup;
import com.app.entities.Farmer;
import com.app.enums.Role;
import com.app.repository.FarmerRepository;

@Service
public class FarmerServiceImpl implements FarmerService {

	@Autowired
	private FarmerRepository farmerRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public FarmerSignup farmerRegistration(FarmerSignup reqDTO) {
		
		Farmer farmer = mapper.map(reqDTO,Farmer.class);
		
		if(farmerRepository.existsByEmail(reqDTO.getEmail()))
			throw new ApiException("Email already exist !");
		
		farmer.setPassword(encoder.encode(farmer.getPassword()));
		farmer.setRole(Role.FARMER); 
		return mapper.map(farmerRepository.save(farmer), FarmerSignup.class);
	}


	@Override
	public List<FarmerDto> displayAllFarmers() {

		List<Farmer> farmer=farmerRepository.findAll();
		return farmer.stream().map(user->mapper.map(user, FarmerDto.class)).collect(Collectors.toList());

	}

	@Override
	public void deleteFarmer(Long id) {
		  Farmer farmer = farmerRepository.findById(id).orElseThrow(() -> new RuntimeException("Farmer not found"));
		  farmerRepository.delete(farmer);
	}

	@Override
	public FarmerDto updateFarmer(Long farmerId, FarmerDto updateFarmer) {

		Farmer farmer=farmerRepository.findById(farmerId)
				.orElseThrow(()-> new ResourceNotFoundException("Farmer not found with ID: " + farmerId));
		
		mapper.map(updateFarmer, farmer);
		
		farmer=farmerRepository.save(farmer);
		
		return mapper.map(farmer, FarmerDto.class);
	
	}

	@Override
	public FarmerDto getFarmerById(Long farmerId) {
		Farmer farmer=farmerRepository.findById(farmerId).orElseThrow(()-> new ResourceNotFoundException("Farmer not found"));
		
		return mapper.map(farmer, FarmerDto.class);
	}
	
	@Override
    public void deleteFarmerByEmail(String email) {
        Farmer farmer = farmerRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Farmer not found with email: " + email));
        farmerRepository.delete(farmer);
    }

    @Override
    public FarmerDto updateFarmerByEmail(String email, FarmerDto updateFarmer) {
        Farmer farmer = farmerRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Farmer not found with email: " + email));

        mapper.map(updateFarmer, farmer);
        farmer = farmerRepository.save(farmer);
        
        return mapper.map(farmer, FarmerDto.class);
    }
	
	
	

}
