package com.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.app.custom_exception.ApiException;
import com.app.dto.MerchantSignup;
import com.app.dto.UserSignup;
import com.app.entities.Merchant;
import com.app.repository.MerchantRepository;

public class MerchantServiceImpl implements MerchantService{

	
	@Autowired
	private MerchantRepository merchantDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public MerchantSignup merchantRegistration(MerchantSignup reqDTO) {
		Merchant merchant = mapper.map(reqDTO,Merchant.class);
		if(merchantDao.findByEmail(reqDTO.getEmail()))
			throw new ApiException("Email already exist!");
		
		merchant.setPassword(encoder.encode(merchant.getPassword()));
		return mapper.map(merchantDao.save(merchant), MerchantSignup.class);
			
	}

}
