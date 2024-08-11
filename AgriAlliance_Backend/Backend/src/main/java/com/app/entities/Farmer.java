package com.app.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.app.enums.Role;

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
    
    @OneToMany(mappedBy = "farmer")
    private List<InstrumentBooking> instrumentBookings;

   
    
   
}
