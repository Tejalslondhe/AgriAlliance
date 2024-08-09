package com.app.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.app.entities.Address;
import com.app.enums.Crop;
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
}
