package com.app.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.app.entities.Address;
import com.app.enums.Crop;
<<<<<<< HEAD
import com.app.enums.Role;
=======
>>>>>>> 8ca407d31f1d0e6511aa7659dc3571b9ce854503
import com.app.enums.Skill;

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
public class WorkerDto {

	private Long workerId;

	private String firstName;

	private String lastName;

	private String email;

	private String password;

	private String contactNumber;

	private String aadharNo;

	private Address address;

	private Integer noOfGroupMembers;

	@Enumerated(EnumType.STRING)
	private Skill skills;

	@Enumerated(EnumType.STRING)
	private Crop crop;
<<<<<<< HEAD
	
	@Enumerated(EnumType.STRING)
    private Role role;
=======
>>>>>>> 8ca407d31f1d0e6511aa7659dc3571b9ce854503
}
