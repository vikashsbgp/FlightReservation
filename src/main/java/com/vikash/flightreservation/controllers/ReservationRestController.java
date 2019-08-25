package com.vikash.flightreservation.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vikash.flightreservation.dto.ReservationUpdateRequest;
import com.vikash.flightreservation.entities.Reservation;
import com.vikash.flightreservation.exception.handling.ReservationNotFoundException;
import com.vikash.flightreservation.repos.ReservationRepository;

@RestController
public class ReservationRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);
	
	@Autowired
	private ReservationRepository reservationRepository;

	@GetMapping("reservations/{id}")
	public Optional<Reservation> findReservation(@PathVariable("id") Long id) {
		LOGGER.info("Inside findReservation()" + id);
		Optional<Reservation> result = reservationRepository.findById(id);
		if (!result.isPresent()) {
			throw new ReservationNotFoundException("id - " + id);
		}
		return result;
	}
	
	@PostMapping("reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		
		LOGGER.info("Inside updateReservation()" + request);
		Optional<Reservation> reservation = reservationRepository.findById(request.getId());
		
		if (!reservation.isPresent())
			throw new ReservationNotFoundException("Wrong Data");
		
		reservation.get().setNumber_of_bags(request.getNumberOfBags());
		reservation.get().setChecked_in(request.getCheckedIn());
		return reservationRepository.save(reservation.get());
	}
	
}
