package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.InstrumentBooking;

public interface InstrumentsBookingRepository extends JpaRepository<InstrumentBooking, Long>{

	// Example of a custom query method
    @Query("SELECT b FROM InstrumentBooking b WHERE b.farmer.id = :farmerId")
    List<InstrumentBooking> findBookingsByFarmerId(@Param("farmerId") Long farmerId);



}
