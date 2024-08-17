package com.app.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.app.entities.Farmer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString

public class PasswordResetToken {
	 private static final int EXPIRATION = 60 * 24;

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String token;

	    @ManyToOne
	    @JoinColumn(name = "farmer_id", nullable = false)
	    private Farmer farmer;

	    private Date expiryDate;

	    public PasswordResetToken() {}

	    public PasswordResetToken(String token, Farmer farmer) {
	        this.token = token;
	        this.farmer = farmer;
	        this.expiryDate = calculateExpiryDate(EXPIRATION);
	    }

	    private Date calculateExpiryDate(int expiryTimeInMinutes) {
	        return new Date(System.currentTimeMillis() + expiryTimeInMinutes * 60 * 1000);
	    }
}
