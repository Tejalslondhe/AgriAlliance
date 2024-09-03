package com.app.services;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ApiException;
import com.app.custom_exception.ResourceNotFoundException;
import com.app.entities.Farmer;
import com.app.entities.PasswordResetToken;
import com.app.repository.FarmerRepository;
import com.app.repository.PasswordResetTokenRepository;
import com.app.repository.UserRepository;

@Service
public class ForgotPasswordService {

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String initiatePasswordReset(String email) {
        Farmer farmer = farmerRepository.findByEmail(email)
            .orElseThrow(() -> new ResourceNotFoundException("No farmer found with this email."));

        // Create a password reset token
        String token = UUID.randomUUID().toString();
        PasswordResetToken resetToken = new PasswordResetToken(token, farmer);
        passwordResetTokenRepository.save(resetToken);


        // Since no email is being sent, you might return the token for testing or logging
        return "Password reset token has been generated.";
    }

   
    
    public String resetPassword(String token, String newPassword) {
        Optional<PasswordResetToken> optionalToken = passwordResetTokenRepository.findByToken(token);

        if (!optionalToken.isPresent() || optionalToken.get().getExpiryDate().before(new Date())) {
            return "Invalid or expired token.";
        }

        PasswordResetToken passwordResetToken = optionalToken.get();
        Farmer farmer = passwordResetToken.getFarmer();
        if (passwordResetToken.getExpiryDate().before(new Date())) {
            return "Token has expired.";
        }

        Farmer farmer1 = passwordResetToken.getFarmer();
        if (farmer1 == null) {
            return "Farmer not found.";
        }

        farmer1.setPassword(passwordEncoder.encode(newPassword));
        farmerRepository.save(farmer1);

        // Optionally, delete the token after successful reset
        passwordResetTokenRepository.delete(passwordResetToken);

        return "Password has been reset successfully.";
    }    
	  }
