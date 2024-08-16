package com.app.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "instruments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instrumentId;

    private String name;
    private String type;
    private boolean availabilityStatus;
    private Double ratePerDay;

    @JsonIgnore
    @OneToMany(mappedBy = "instrument",fetch = FetchType.EAGER)
    private List<InstrumentBooking> instrumentBookings;

    
}

