package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DoctorSignup;
import com.app.dto.FarmerSignup;
import com.app.dto.MerchantSignup;
import com.app.dto.SigninRequest;
import com.app.dto.SigninResponse;
import com.app.dto.WorkerSignup;
import com.app.entities.User;
import com.app.security.JwtUtils;
import com.app.services.DoctorService;
import com.app.services.FarmerService;
import com.app.services.MerchantService;
import com.app.services.WorkerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/auth")
public class SigninSignupController {

    @Autowired
    private FarmerService farmerService;

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private WorkerService workerService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authMgr;

    // Signup for Farmer
    @PostMapping("/farmers/signup")
    public ResponseEntity<?> farmerSignup(@RequestBody @Valid FarmerSignup dto) {
        System.out.println("Farmer sign-up request: " + dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(farmerService.farmerRegistration(dto));
    }

    // Signup for Merchant
    @PostMapping("/merchants/signup")
    public ResponseEntity<?> merchantSignup(@RequestBody @Valid MerchantSignup dto) {
        System.out.println("Merchant sign-up request: " + dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(merchantService.merchantRegistration(dto));
    }

    // Signup for Worker
    @PostMapping("/workers/signup")
    public ResponseEntity<?> workerSignup(@RequestBody @Valid WorkerSignup dto) {
        System.out.println("Worker sign-up request: " + dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(workerService.workerRegistration(dto));
    }

    // Signup for Doctor
    @PostMapping("/doctors/signup")
    public ResponseEntity<?> doctorSignup(@RequestBody @Valid DoctorSignup dto) {
        System.out.println("Doctor sign-up request: " + dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.doctorRegistration(dto));
    }

    // Signin (common for all user types)
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody @Valid SigninRequest request) {
        System.out.println("Sign-in request: " + request);

        try {
            // Create a token to store unverified user email and password
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());

            // Authenticate the token using the AuthenticationManager
            Authentication verifiedToken = authMgr.authenticate(token);

            // Generate JWT token
            String jwtToken = jwtUtils.generateJwtToken(verifiedToken);
            
            SigninResponse resp = new SigninResponse(jwtToken, "Authentication successful!");
            return ResponseEntity.status(HttpStatus.OK).body(resp);

        } catch (BadCredentialsException e) {
            System.err.println("Invalid credentials: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");

        } catch (AuthenticationException e) {
            System.err.println("Authentication error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed.");

        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }
}

