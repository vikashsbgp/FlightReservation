package com.vikash.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vikash.flightreservation.dto.ReservationRequest;
import com.vikash.flightreservation.entities.Flight;
import com.vikash.flightreservation.entities.Reservation;
import com.vikash.flightreservation.repos.FlightRepository;
import com.vikash.flightreservation.services.ReservationService;

@Controller
public class ReservationController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		
		LOGGER.info("Inside showCompleteReservation()" + flightId);
		Flight flight = flightRepository.findById(flightId).get();
		LOGGER.info("Flight: " + flight);
		modelMap.addAttribute("flight", flight);
		return "completeReservation";
	}
	
	@RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
	public String completeReservation(@ModelAttribute("request") ReservationRequest request, ModelMap modelMap) {
		
		LOGGER.info("Inside completeReservation()" + request);
		Reservation reservation = reservationService.bookFlight(request);
		LOGGER.info("Reservation: " + reservation);
		modelMap.addAttribute("msg", "Reservation created successfully and id is: " + reservation.getId());
		LOGGER.info("Reservation created successfully and redirecting to reservationConfirmation page");
		return "reservationConfirmation";
	}

}
