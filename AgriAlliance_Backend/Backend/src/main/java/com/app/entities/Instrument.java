package com.app.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
    private String availabilityStatus;
    private Double ratePerDay;

    @OneToMany(mappedBy = "instrument")
    private List<InstrumentBooking> instrumentBookings;

    
}

