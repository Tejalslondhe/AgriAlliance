package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseSignup {

	@NotBlank(message = "First Name required")
	private String firstName;
	
	@NotBlank(message = "First Name required")
	private String lastName;
	
	@Email(message = "Invalid Email!!!")
	private String email;
	
	@JsonProperty(access = Access.WRITE_ONLY)// this property only used during de-ser.
	private String password;
	
	private String contactNumber;
	
	private String aadharNo;
	
	private AddressDTO address;

}
