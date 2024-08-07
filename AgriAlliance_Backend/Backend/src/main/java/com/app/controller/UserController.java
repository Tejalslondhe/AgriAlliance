package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.SigninRequest;
import com.app.dto.SigninResponse;
import com.app.dto.UserSignup;
import com.app.services.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private AuthenticationManager authMgr;
	
	@PostMapping("/usersignup")
	public ResponseEntity<?> userSignup(@RequestBody @Valid UserSignup dto){
		System.out.println("in sign up " + dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.userRegistration(dto));	
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody @Valid SigninRequest request){
		System.out.println("in sign in" + request);
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword());
		
		Authentication verifiedToken = authMgr.authenticate(token);
		
		SigninResponse resp = new SigninResponse(jwtUtils.generateJwtToken),"Successful Auth!!!");
		return ResponseEntity.status(HttpStatus.CREATED).body(resp);
	}
	

}
