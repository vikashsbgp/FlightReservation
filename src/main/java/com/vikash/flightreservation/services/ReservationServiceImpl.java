package com.vikash.flightreservation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikash.flightreservation.dto.ReservationRequest;
import com.vikash.flightreservation.entities.Flight;
import com.vikash.flightreservation.entities.Passenger;
import com.vikash.flightreservation.entities.Reservation;
import com.vikash.flightreservation.repos.FlightRepository;
import com.vikash.flightreservation.repos.PassengerRepository;
import com.vikash.flightreservation.repos.ReservationRepository;
import com.vikash.flightreservation.util.EmailUtil;
import com.vikash.flightreservation.util.PdfGeneretor;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	PassengerRepository passengerRepository;

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	PdfGeneretor pdfGenerator;

	@Autowired
	EmailUtil emailUtil;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		LOGGER.info("Inside bookFlight()" + request);

		Long flightId = request.getFlightId();
		Flight flight = flightRepository.findById(flightId).get();
		
		LOGGER.info("Selected flight " + flight);

		Passenger passenger = new Passenger();
		passenger.setId(flightId);
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setMiddleName(request.getPassengerMiddleName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		LOGGER.info("Passenger details: " + savedPassenger);

		Reservation reservation = new Reservation();
		reservation.setId(flightId);
		reservation.setChecked_in(true);
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		Reservation savedReservation = reservationRepository.save(reservation);
		
		LOGGER.info("Reservation details: " + savedReservation);
		
		String filePath = System.getProperty("user.dir") + "/reservation⁩" + savedReservation.getId() + ".pdf";
		pdfGenerator.generateItinerary(savedReservation, filePath);
		
		LOGGER.info("PDF generated in path" + filePath);
		
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		
		LOGGER.info("Email sent to " + passenger.getEmail());

		return savedReservation;
	}

}
