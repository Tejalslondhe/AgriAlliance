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
        
        if(farmerRepository.existsByEmail(reqDTO.getEmail())) {
            throw new ApiException("Email already exists!");
        }

        Farmer farmer = mapper.map(reqDTO, Farmer.class);
        farmer.setPassword(encoder.encode(farmer.getPassword()));
        farmer.setRole(Role.FARMER); 
        
        return mapper.map(farmerRepository.save(farmer), FarmerSignup.class);
    }

    @Override
    public void deleteFarmerByEmail(String email) {
        Farmer farmer = farmerRepository.findByEmail(email)
            .orElseThrow(() -> new ResourceNotFoundException("Farmer not found with email: " + email));
        farmerRepository.delete(farmer);
    }

    @Override
    public FarmerDto updateFarmerByEmail(String email, FarmerDto updateFarmer) {
        Farmer farmer = farmerRepository.findByEmail(email)
            .orElseThrow(() -> new ResourceNotFoundException("Farmer not found with email: " + email));

        mapper.map(updateFarmer, farmer);
        farmer = farmerRepository.save(farmer);
        
        return mapper.map(farmer, FarmerDto.class);
    }

    @Override
    public List<FarmerDto> displayAllFarmers() {
        List<Farmer> farmers = farmerRepository.findAll();
        return farmers.stream()
                      .map(farmer -> mapper.map(farmer, FarmerDto.class))
                      .collect(Collectors.toList());
    }

    @Override
    public FarmerDto getFarmerById(Long farmerId) {
        Farmer farmer = farmerRepository.findById(farmerId)
                .orElseThrow(() -> new ResourceNotFoundException("Farmer not found with ID: " + farmerId));
        
        return mapper.map(farmer, FarmerDto.class);
    }

	
}
