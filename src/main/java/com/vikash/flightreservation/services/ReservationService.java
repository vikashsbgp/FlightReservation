package com.vikash.flightreservation.services;

import com.vikash.flightreservation.dto.ReservationRequest;
import com.vikash.flightreservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);

}
