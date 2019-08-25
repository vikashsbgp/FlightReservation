package com.vikash.flightreservation.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vikash.flightreservation.entities.Flight;
import com.vikash.flightreservation.repos.FlightRepository;

@Controller
public class FlightController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

	@Autowired
	private FlightRepository flightRepository;

	@RequestMapping("/findFlights")
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("departureDate") String departureDate, ModelMap modelMap) {
		
		LOGGER.info("Inside findFlights()" + from + "," + to +","+departureDate);
		List<Flight> flights = flightRepository.findFlights(from, to, departureDate);
		modelMap.addAttribute("flights", flights);
		LOGGER.info("Flights from " + from + "to " + to + "are " + flights);
		return "displayFlights";
	}

}
