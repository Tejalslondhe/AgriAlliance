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
import com.app.dto.UserSignup;
import com.app.dto.UsersDTO;
import com.app.entities.User;
import com.app.repository.UserRepository;

@Service
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
		
		if(userDao.existsByEmail(reqDTO.getEmail()))
			throw new ApiException("Email already exist !");
		
		user.setPassword(encoder.encode(user.getPassword()));
		return mapper.map(userDao.save(user), UserSignup.class);
	}

	@Override
	public UsersDTO addNewUser(UsersDTO newUser) throws InvalidCredentialsException {
        User user=mapper.map(newUser,User.class);
     // Handling Address as a possible detached entity
        if (user.getAddress() != null) {
            user.getAddress().setId(null); // Ensures a new Address is created
        }
       User savedUser= userDao.save(user);
        return mapper.map(savedUser, UsersDTO.class);
	}

	@Override
	public List<UsersDTO> displayAllUers() {

		List<User> users=userDao.findAll();
		return users.stream().map(user->mapper.map(user, UsersDTO.class)).collect(Collectors.toList());

	}

	@Override
	public void deleteUser(Long id) {
		  User user = userDao.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		  userDao.delete(user);
	}

	@Override
	public UsersDTO updateUser(Long userId, UsersDTO updateUser) {

		User user=userDao.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User not found with ID: " + userId));
		
		mapper.map(updateUser, user);
		
		user=userDao.save(user);
		
		return mapper.map(user, UsersDTO.class);
	
	}

	@Override
	public UsersDTO getUserById(Long userId) {
		User user=userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found"));
		
		return mapper.map(user, UsersDTO.class);
	}
	
	
	

}
