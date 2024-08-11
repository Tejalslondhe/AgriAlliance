package com.app.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.app.entities.Address;
<<<<<<< HEAD
import com.app.enums.Role;
=======
>>>>>>> 8ca407d31f1d0e6511aa7659dc3571b9ce854503
import com.app.enums.Specialization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
	private Long doctorId;

	private String firstName;

	private String lastName;

	private String email;

	private String password;

	private String contactNumber;

	private String aadharNo;

	private Address address;

	@Enumerated(EnumType.STRING)
	private Specialization specialization;
<<<<<<< HEAD
	
	@Enumerated(EnumType.STRING)
    private Role role;
=======
>>>>>>> 8ca407d31f1d0e6511aa7659dc3571b9ce854503
}
