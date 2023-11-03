<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Send Quote</title>
</head>
<body>
<h1>New Request</h1> <br>
	<form action="newRequest">
	<table border="1" cellpadding="5">
				<tr>
					<th>Quote ID </th>
					<td align="center" colspan="3">
						<input type="text" name="requestID" size="45"  value="M324233120" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Status </th>
					<td align="center" colspan="3">
						<input type="text" name="status" size="1" value="P/S/R" onfocus="this.value=''">
					</td>
				</tr>
				
				<tr>
					<th>Work Period </th>
					<td align="center" colspan="3">
						<input type="text" name="workPeriod" size="20" value="Enter No. of days" onfocus="this.value=''">
					</td>
				</tr>
				
				<tr>
					<th>Note </th>
					<td align="center" colspan="3">
						<input type="text" name="note" size="100" value="Any notes" onfocus="this.value=''">
					</td>
				</tr>
				
				<tr>
					<th>Price </th>
					<td align="center" colspan="3">
						<input type="text" name="price" size="20" value="Enter the quote price" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="5">
						<input type="submit" value="Submit Request"/>
					</td>
				</tr>
	
	</form>
</body>
</html>
