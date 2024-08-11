package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UsersDTO;
import com.app.entities.User;
import com.app.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public UsersDTO add(@RequestBody UsersDTO userdto)
	{
		return userService.addNewUser(userdto);
	}
	
	@GetMapping
	public List<UsersDTO> display()
	{
		return userService.displayAllUers();
	}
	
	@DeleteMapping("/{id}")
	public  ResponseEntity<Void> delete(@PathVariable Long id)
	{
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public UsersDTO update(@PathVariable Long id, @RequestBody UsersDTO userdto)
	{
		return userService.updateUser(id,userdto);
	}
}
