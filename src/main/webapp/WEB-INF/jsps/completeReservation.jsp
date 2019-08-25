<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Complete Reservation</title>
</head>
<body>
<h2>Complete Reservation</h2>
Airline: ${flight.operating_airlines}<br/>
From: ${flight.departure_city}<br/>
To: ${flight.arrival_city}<br/>

<form action="completeReservation" method="post">
	<pre>
		<h2>Passenger Details:</h2>
		First Name:	<input type="text" name="passengerFirstName"/>
		Middle Name:	<input type="text" name="passengerMiddleName"/>
		Last Name:	<input type="text" name="passengerLastName"/>
		Email:		<input type="text" name="passengerEmail"/>
		Phone:		<input type="text" name="passengerPhone"/>
		
		<h2>Card Details:</h2>
		Name on Card:<input type="text" name="nameOnTheCard"/>
		Card Number:<input type="text" name="cardNumber"/>
		Expiry Date:<input type="text" name="expiryDate" placeholder="mm/yy" />
		CVV:		<input type="text" name="cvv"/>
		
		<input type="hidden" name="flightId" value="${flight.id}"/>
		<input type="submit" value="Confirm"/>
	</pre>
</form>

</body>
</html>