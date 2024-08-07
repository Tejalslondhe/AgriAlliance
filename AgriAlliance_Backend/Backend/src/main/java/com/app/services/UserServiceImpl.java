package com.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.app.custom_exception.ApiException;
import com.app.custom_exception.InvalidCredentialsException;
import com.app.dto.UserSignup;
import com.app.entities.User;
import com.app.repository.UserRepository;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public UserSignup userRegistration(UserSignup reqDTO) {
		
		User user = mapper.map(reqDTO,User.class);
		
		if(userDao.findByEmail(reqDTO.getEmail()))
			throw new ApiException("Email already exist !");
		
		user.setPassword(encoder.encode(user.getPassword()));
		return mapper.map(userDao.save(user), UserSignup.class);
	}
	

}
