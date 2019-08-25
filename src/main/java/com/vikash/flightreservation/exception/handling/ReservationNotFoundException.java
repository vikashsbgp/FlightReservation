package com.vikash.flightreservation.exception.handling;

public class ReservationNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReservationNotFoundException(String exception) {
		super(exception);
	}

}
