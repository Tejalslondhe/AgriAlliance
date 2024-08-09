package com.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.custom_exception.InvalidCredentialsException;
import com.app.dto.UserSignup;
import com.app.dto.UsersDTO;

@Service
public interface UserService {

	// add signup method
	UserSignup userRegistration(UserSignup reqDTO);

	UsersDTO addNewUser(UsersDTO newUser) throws InvalidCredentialsException;

	List<UsersDTO> displayAllUers();

	void deleteUser(Long id);

	UsersDTO updateUser(Long userId, UsersDTO updateUser);

	UsersDTO getUserById(Long userId);

}
