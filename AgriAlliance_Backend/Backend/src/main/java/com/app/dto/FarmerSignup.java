package com.app.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.app.enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FarmerSignup extends BaseSignup{
	
	@JsonProperty(access = Access.READ_ONLY) // this property only used during ser.
	private Long farmerId;

	@Enumerated(EnumType.STRING)
    private Role role=Role.FARMER;
}
