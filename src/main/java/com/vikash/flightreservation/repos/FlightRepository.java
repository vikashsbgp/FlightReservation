package com.vikash.flightreservation.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vikash.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query(value = "select * from flight where departure_city=:departureCity and arrival_city=:arrivalCity and date_of_departure=:departureDate", nativeQuery = true)
	List<Flight> findFlights(@Param("departureCity") String from, @Param("arrivalCity") String to,
			@Param("departureDate") String departureDate);

}
