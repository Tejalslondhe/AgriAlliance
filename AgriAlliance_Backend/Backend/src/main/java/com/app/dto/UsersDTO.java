package com.app.dto;

import com.app.entities.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO {

	private Long userId;

	private String firstName;

	private String lastName;

	private String email;

	private String password;

	private String contactNumber;

	private String aadharNo;

	private Address address;
}
