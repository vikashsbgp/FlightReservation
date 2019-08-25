package com.vikash.flightreservation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vikash.flightreservation.entities.Reservation;
import com.vikash.flightreservation.repos.ReservationRepository;
import com.vikash.flightreservation.util.PdfGeneretor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightreservationApplicationTests {
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	PdfGeneretor pdfGenerator;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testGenerateItenarary() {
		
		Reservation reservation = reservationRepository.findById(1l).get();
		//String filePath = "/Users⁩/⁨vikashsingh⁩/⁨Documents/Reservation/reservation⁩" + reservation.getId() + ".pdf";
		String filePath = System.getProperty("user.dir") + "/reservation⁩" + reservation.getId() + ".pdf";
		System.out.println(filePath);
		pdfGenerator.generateItinerary(reservation, filePath);
	}

}
