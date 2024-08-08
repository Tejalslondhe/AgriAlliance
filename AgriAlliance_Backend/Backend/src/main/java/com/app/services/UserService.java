package com.app.services;

import org.springframework.stereotype.Service;

import com.app.dto.UserSignup;

@Service
public interface UserService {
	
	//add signup method
	UserSignup userRegistration(UserSignup reqDTO);


}
