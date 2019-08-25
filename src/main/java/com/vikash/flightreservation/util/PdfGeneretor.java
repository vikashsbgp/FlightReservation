package com.vikash.flightreservation.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.vikash.flightreservation.entities.Reservation;

@Component
public class PdfGeneretor {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PdfGeneretor.class);
	
	public void generateItinerary(Reservation reservation, String filePath) {
		
		LOGGER.info("Inside generateItinerary()" + reservation + "," + filePath);
		
		Document document = new Document();
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			document.open();
			document.add(generateTable(reservation));
			document.close();
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
		
	}

	private PdfPTable generateTable(Reservation reservation) {
		
		LOGGER.info("Inside generateTable()" + reservation);
		PdfPTable table = new PdfPTable(2);
		
		PdfPCell cell;
		
		cell = new PdfPCell(new Phrase("Flight Itinerary"));
		cell.setColspan(2);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Flight Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("Departure City");
		table.addCell(reservation.getFlight().getDeparture_city());
		
		table.addCell("Arrival City");
		table.addCell(reservation.getFlight().getArrival_city());
		
		table.addCell("Flight Number");
		table.addCell(reservation.getFlight().getFlight_number());
		
		table.addCell("Date of Departure");
		table.addCell(reservation.getFlight().getDate_of_departure());
		
		table.addCell("Departure time");
		table.addCell(reservation.getFlight().getEstimated_departure_time().toString());
		
		cell = new PdfPCell(new Phrase("Passenger Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("First Name");
		table.addCell(reservation.getPassenger().getFirstName());
		
		table.addCell("Last Name");
		table.addCell(reservation.getPassenger().getLastName());
		
		table.addCell("Email");
		table.addCell(reservation.getPassenger().getEmail());
		
		table.addCell("Phone");
		table.addCell(reservation.getPassenger().getPhone());
		
		return table;
	}

}
