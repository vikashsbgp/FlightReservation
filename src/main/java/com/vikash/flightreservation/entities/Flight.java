package com.vikash.flightreservation.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;

@Entity
public class Flight extends AbstractEntity {
	
	private String flight_number;
	private String operating_airlines;
	private String departure_city;
	private String arrival_city;
	private String date_of_departure;
	private Timestamp estimated_departure_time;

	public String getFlight_number() {
		return flight_number;
	}

	public void setFlight_number(String flight_number) {
		this.flight_number = flight_number;
	}

	public String getOperating_airlines() {
		return operating_airlines;
	}

	public void setOperating_airlines(String operating_airlines) {
		this.operating_airlines = operating_airlines;
	}

	public String getDeparture_city() {
		return departure_city;
	}

	public void setDeparture_city(String departure_city) {
		this.departure_city = departure_city;
	}

	public String getArrival_city() {
		return arrival_city;
	}

	public void setArrival_city(String arrival_city) {
		this.arrival_city = arrival_city;
	}

	public String getDate_of_departure() {
		return date_of_departure;
	}

	public void setDate_of_departure(String date_of_departure) {
		this.date_of_departure = date_of_departure;
	}

	public Timestamp getEstimated_departure_time() {
		return estimated_departure_time;
	}

	public void setEstimated_departure_time(Timestamp estimated_departure_time) {
		this.estimated_departure_time = estimated_departure_time;
	}
	
	@Override
	public String toString() {
		return "Flight [flight_number=" + flight_number + ", operating_airlines=" + operating_airlines
				+ ", departure_city=" + departure_city + ", arrival_city=" + arrival_city + ", date_of_departure="
				+ date_of_departure + ", estimated_departure_time=" + estimated_departure_time + "]";
	}

}
