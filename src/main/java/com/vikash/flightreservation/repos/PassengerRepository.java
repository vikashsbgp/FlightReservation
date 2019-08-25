package com.vikash.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vikash.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
