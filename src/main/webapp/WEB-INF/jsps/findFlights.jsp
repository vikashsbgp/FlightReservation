<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Flights</title>
</head>
<body>
	<h1>Find Flights: </h1>
	<form action="findFlights" method="post">
		<pre>
			From: <input type="text" name="from"/>
			To:   <input type="text" name="to"/>
			Date:   <input type="text" name="departureDate" placeholder="yyyy-mm-dd" />
				<input type="submit" name="find"/>
		</pre>
	</form>
</body>
</html>