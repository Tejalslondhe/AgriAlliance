package com.app.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ApiException;
import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.FarmerDto;
import com.app.dto.FarmerSignup;
import com.app.entities.Farmer;
import com.app.entities.PasswordResetToken;
import com.app.enums.Role;
import com.app.repository.FarmerRepository;
import com.app.repository.PasswordResetTokenRepository;
import com.app.entities.User;
@Service
public class FarmerServiceImpl implements FarmerService {

<<<<<<< HEAD
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
=======
>>>>>>> 5c5619f252e31f143f79a6eac4c406433256a199


	 @Autowired
	    private FarmerRepository farmerDao;

<<<<<<< HEAD
		List<Farmer> farmer=farmerRepository.findAll();
		return farmer.stream().map(user->mapper.map(user, FarmerDto.class)).collect(Collectors.toList());
=======
	    @Autowired
	    private PasswordResetTokenRepository tokenRepository;
>>>>>>> 5c5619f252e31f143f79a6eac4c406433256a199

	    @Autowired
	    private ModelMapper mapper;

<<<<<<< HEAD
	@Override
	public void deleteFarmer(Long id) {
		  Farmer farmer = farmerRepository.findById(id).orElseThrow(() -> new RuntimeException("Farmer not found"));
		  farmerRepository.delete(farmer);
	}
=======
	    @Autowired
	    private PasswordEncoder encoder;
>>>>>>> 5c5619f252e31f143f79a6eac4c406433256a199

	    @Override
	    public FarmerSignup farmerRegistration(FarmerSignup reqDTO) {
	        Farmer farmer = mapper.map(reqDTO, Farmer.class);

<<<<<<< HEAD
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
	
	
	
=======
	        if (farmerDao.existsByEmail(reqDTO.getEmail()))
	            throw new ApiException("Email already exists!");

	        farmer.setPassword(encoder.encode(farmer.getPassword()));
	        farmer.setRole(Role.FARMER);
	        return mapper.map(farmerDao.save(farmer), FarmerSignup.class);
	    }

	    @Override
	    public List<FarmerDto> displayAllFarmers() {
	        List<Farmer> farmers = farmerDao.findAll();
	        return farmers.stream().map(user -> mapper.map(user, FarmerDto.class)).collect(Collectors.toList());
	    }

	    @Override
	    public void deleteFarmer(Long id) {
	        Farmer farmer = farmerDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Farmer not found"));
	        farmerDao.delete(farmer);
	    }

	    @Override
	    public FarmerDto updateFarmer(Long farmerId, FarmerDto updateFarmer) {
	        Farmer farmer = farmerDao.findById(farmerId)
	                .orElseThrow(() -> new ResourceNotFoundException("Farmer not found with ID: " + farmerId));

	        mapper.map(updateFarmer, farmer);
	        farmer = farmerDao.save(farmer);

	        return mapper.map(farmer, FarmerDto.class);
	    }

	    @Override
	    public FarmerDto getFarmerById(Long farmerId) {
	        Farmer farmer = farmerDao.findById(farmerId)
	                .orElseThrow(() -> new ResourceNotFoundException("Farmer not found"));

	        return mapper.map(farmer, FarmerDto.class);
	    }

	    @Override
	    public String initiatePasswordReset(String email) {
	        Farmer farmer = farmerDao.findByEmail(email)
	                .orElseThrow(() -> new ResourceNotFoundException("No farmer found with this email"));

	        String token = UUID.randomUUID().toString();
	        PasswordResetToken resetToken = new PasswordResetToken(token, farmer);
	        tokenRepository.save(resetToken);

	        // Email sending logic would be here, but is omitted per your request

	        return "Password reset token has been generated.";
	    }

	    @Override
	    public String resetPassword(String token, String newPassword) {
	        PasswordResetToken resetToken = tokenRepository.findByToken(token)
	                .orElseThrow(() -> new ResourceNotFoundException("Invalid or expired token"));

	        if (resetToken.getExpiryDate().before(new Date())) {
	            throw new ApiException("Token has expired");
	        }

	        Farmer farmer = resetToken.getFarmer();
	        farmer.setPassword(encoder.encode(newPassword));
	        farmerDao.save(farmer);

	        tokenRepository.delete(resetToken);

	        return "Password has been reset successfully.";
	    }

>>>>>>> 5c5619f252e31f143f79a6eac4c406433256a199

}
