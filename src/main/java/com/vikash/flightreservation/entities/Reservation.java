package com.vikash.flightreservation.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Reservation extends AbstractEntity {

	private boolean checked_in;
	private int number_of_bags;
	
	@OneToOne
	private Passenger passenger;
	
	@OneToOne
	private Flight flight;

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + getId() + ", checkedIn=" + checked_in + ", numberOfBags=" + number_of_bags + ", passenger="
				+ passenger + ", flight=" + flight + "]";
	}

	public boolean isChecked_in() {
		return checked_in;
	}

	public void setChecked_in(boolean checked_in) {
		this.checked_in = checked_in;
	}

	public int getNumber_of_bags() {
		return number_of_bags;
	}

	public void setNumber_of_bags(int number_of_bags) {
		this.number_of_bags = number_of_bags;
	}

}
