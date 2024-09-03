package com.app.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.app.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "farmers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Farmer extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long farmerId;

    @Enumerated(EnumType.STRING)
    private Role role=Role.FARMER;
    
    @JsonIgnore
    @OneToMany(mappedBy = "farmer",fetch = FetchType.EAGER)
    private List<InstrumentBooking> instrumentBookings;

	public Farmer orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

   
    
   
}
