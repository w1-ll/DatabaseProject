<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request</title>
</head>
<body>
	<h1>New Request</h1> <br>
	<form action="newRequest">
	<table border="1" cellpadding="5">
				<tr>
					<th>Request ID </th>
					<td align="center" colspan="3">
						<p>${requestID}</p>
					<input type="hidden" name = "requestID" value="${requestID}">
					<input type="hidden" name = "status" value="P">			
					</td>
				</tr>
				
				<tr>
					<th>Note </th>
					<td align="center" colspan="3">
						<input type="text" name="note" size="100" value="Any notes" onfocus="this.value=''">
					</td>
				</tr>
				
				<tr>
					<th>Tree Distance </th>
					<td align="center" colspan="3">
						<input type="text" name="tree_distance" size="100" value="Tree distance from house" onfocus="this.value=''">
					</td>
					
				</tr>
				
				<tr>
					<th>Trunk Size </th>
					<td align="center" colspan="3">
						<input type="text" name="trunk_size" size="100" value="Approx. Trunk Size" onfocus="this.value=''">
					</td>
					
				</tr>
				
				<tr>
					<th>Tree Height</th>
					<td align="center" colspan="3">
						<input type="text" name="tree_height" size="100" value="Approx. Tree Height" onfocus="this.value=''">
					</td>
					
				</tr>
				
				<tr>
					<th>Tree location</th>
					<td align="center" colspan="3">
						<input type="text" name="tree_location" size="100" value="Tree Location" onfocus="this.value=''">

					</td>
					
				</tr>
				
				<tr>
					<td align="center" colspan="5">
						<input type="submit" value="Submit Request"/>
					</td>
				</tr>
	</table>
	</form>
</body>
</html>
