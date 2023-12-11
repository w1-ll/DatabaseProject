<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Details</title>
</head>
<body>
	<center>
	<h1>Order Details:</h1>
	<table border="1" cellpadding="5">
				<tr>
					<th>OrderID</th>
					<td align="center" colspan="3">
						<p>${orderID}</p>
						
					</td>
				</tr>
								
				<tr>
					<th>Order Status</th>
					<td align="center" colspan="3">
						<p>${status}</p>
					</td>
				</tr>
				<tr>
					<th>Email</th>
					<td align="center" colspan="3">
						<p>${email}</p>
					</td>
				</tr>
				
				<form action="ChangeFinishDate">
				<tr>
					<th>Enter/Alter Finish Date</th>
					<td align="center" colspan="3">
						<input type="date" name="changeFinishDate" onfocus="this.value=''">
						<input type="hidden" name="orderID" value = "${orderID}">
						<input type="submit" value="Enter/Alter Date"/>
				
				
					</td>
				</tr>
				</form>
				
				<tr>
					<th>Finish Date</th>
					<td align="center" colspan="3">
						<p>${finish_date}</p>
						
					</td>
				</tr>
				
				
	</table>
	
	<h1>Tree Details:</h1>
	<table border="1" cellpadding="5">
				<tr>
					<th>Tree Distance</th>
					<td align="center" colspan="3">
						<p>${tree_distance}</p>
						
					</td>
				</tr>
								
				<tr>
					<th>Trunk Size</th>
					<td align="center" colspan="3">
						<p>${trunk_size}</p>
					</td>
				</tr>
				<tr>
					<th>Tree Height</th>
					<td align="center" colspan="3">
						<p>${tree_height}</p>
					</td>
				</tr>
				<tr>
					<th>Tree location</th>
					<td align="center" colspan="3">
						<p>${tree_location}</p>
					</td>
				</tr>
				
	</table>
	</center>
</body>
</html>
