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

import com.vikash.flightreservation.entities.User;
import com.vikash.flightreservation.repos.UserRepository;

@Controller
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		LOGGER.info("Inside showRegistrationPage()");
		return "login/registerUser";
	}

	@RequestMapping("/loginPage")
	public String showLoginPage() {
		LOGGER.info("Inside showLoginPage()");
		return "login/login";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		LOGGER.info("Inside register()" + user);
		userRepository.save(user);
		return "login/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap) {
		
		LOGGER.info("Inside login() email: " + email);

		User user = userRepository.findByEmail(email);

		if (user == null) {
			LOGGER.error("User is not present in DB");
			modelMap.addAttribute("msg", "Invalid email or password. Please try again..");
			return "login/login";
		}

		if (user.getPassword().equals(password)) {
			LOGGER.info("Password matched. Redirecting to find flights");
			return "findFlights";
		}
		else {
			LOGGER.error("Invalid email or password. Please try again..");
			modelMap.addAttribute("msg", "Invalid email or password. Please try again..");
			return "login/login";
		}

	}

}
