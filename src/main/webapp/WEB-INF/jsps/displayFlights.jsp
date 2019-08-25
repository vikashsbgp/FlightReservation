<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Flights</title>
</head>
<body>
	<h2>Flights:</h2>
	<table>
		<tr>
			<th>Airlines</th>
			<th>Departure City</th>
			<th>Arrival City</th>
			<th>Departure Time</th>
		</tr>
		<c:forEach items="${flights}" var="flight">
			<tr>
				<td>${flight.operating_airlines}</td>
				<td>${flight.departure_city}</td>
				<td>${flight.arrival_city}</td>
				<td>${flight.estimated_departure_time}</td>
				<td>
					<a href="showCompleteReservation?flightId=${flight.id}">Select</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>