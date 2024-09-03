package com.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Farmer;
import com.app.entities.PasswordResetToken;
import com.app.repository.FarmerRepository;
import com.app.repository.PasswordResetTokenRepository;
import com.app.services.ForgotPasswordService;

@RestController
@RequestMapping("/api")
public class PasswordResetController {

	@Autowired
    private PasswordResetTokenRepository tokenRepository;

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ForgotPasswordService forgotPasswordService;

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam String email) {
        String response = forgotPasswordService.initiatePasswordReset(email);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam String token, @RequestParam String password) {
        String response = forgotPasswordService.resetPassword(token, password);
        return ResponseEntity.ok(response);
    }
}
