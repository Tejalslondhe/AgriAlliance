package com.app.dto;

import com.app.enums.Specialization;
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
public class DoctorSignup extends BaseSignup{
	
	@JsonProperty(access = Access.READ_ONLY) // this property only used during ser.
	private Long doctorId;

    private Specialization specialization;
	

}
