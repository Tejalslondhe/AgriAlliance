package com.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.dto.UserSignup;
import com.app.entities.User;

@Service
public interface UserService {
	
	//add signup method
	UserSignup userRegistration(UserSignup reqDTO);
	
	List<User> getAllUsers();

}
