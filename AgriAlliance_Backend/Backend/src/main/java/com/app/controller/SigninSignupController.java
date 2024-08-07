package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.SigninRequest;
import com.app.dto.SigninResponse;
import com.app.dto.UserSignup;
import com.app.security.JwtUtils;
import com.app.services.UserService;

@RestController
@RequestMapping("/users")
public class SigninSignupController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private AuthenticationManager authMgr;

	
	@PostMapping("/signup")
	public ResponseEntity<?> userSignup(@RequestBody @Valid UserSignup dto) {
		System.out.println("in sign up " + dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.userRegistration(dto));
	}

	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody @Valid SigninRequest request) {
		System.out.println("in sign in" + request);
		// 1. create a token(implementation of Authentication i/f)
		// to store un verified user email n pwd
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(request.getEmail(),
				request.getPassword());
		//2.  invoke auth mgr's authenticate method;
		Authentication verifiedToken = authMgr.authenticate(token);
			// => authentication n authorization successful !
			//3. In case of successful auth,  create JWT n send it to the clnt in response
		SigninResponse resp = new SigninResponse(jwtUtils.generateJwtToken(verifiedToken), "Successful Auth!!!!");
		return ResponseEntity.status(HttpStatus.CREATED).body(resp);
	}

}

