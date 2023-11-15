<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check Quote</title>
</head>
<body>
	<form action="checkQuote">
	<center><h1>Your given Quote</h1>
	
	<table border="1" cellpadding="5">
				<tr>
					<th>Quote ID </th>
					<td align="center" colspan="3">
						<p>${quoteID}</p>
						<input type="hidden" name = "quoteID" value="${quoteID}">
					</td>
				</tr>
				<tr>
					<th>Status </th>
					<td align="center" colspan="3">
						<p>${user_status}</p>
					</td>
				</tr>
				<tr>
					<th>Contractor Note </th>
					<td align="center" colspan="3">
						<p>${note}</p>
					</td>
				</tr>
				
				<tr>
					<th>Work Period </th>
					<td align="center" colspan="3">
						<p>${work_period}</p>
					</td>
				</tr>
				<tr>
					<th>Your note </th>
					<td align="center" colspan="3">
						<p>${user_note}</p>
					</td>
				</tr>
				<tr>
					<th>Price </th>
					<td align="center" colspan="3">
						<p>${price}</p>
					</td>
				</tr>
				
				<tr>
					<th>Tree Distance </th>
					<td align="center" colspan="3">
						<p>${tree_distance}</p>
					</td>
				</tr>
				
				<tr>
					<th>Trunk Size </th>
					<td align="center" colspan="3">
						<p>${trunk_size}</p>
					</td>
				</tr>
				
				<tr>
					<th>Tree Height </th>
					<td align="center" colspan="3">
						<p>${tree_height}</p>
					</td>
				</tr>
				
				<tr>
					<th>Tree Location </th>
					<td align="center" colspan="3">
						<p>${tree_location}</p>
					</td>
				</tr>
				
				<!--  <tr>
					<td align="center" colspan="5">
						<input type="submit" value="Submit Request"/>
					</td>
				</tr>-->
	</table>
	<br>
	<br><br>
	
	<h2>Your response</h2>
	<table border="1" cellpadding="5">
				<tr> 
				<th>Note</th>
				<td align="center" colspan="3">
						<input type="text" name="note" size="45"  value="Enter your queries" onfocus="this.value=''">
					</td>
				</tr>
				<tr> 
					
				<td align="center" colspan="3">
					<label for="options">Do you accept the contract?:</label>
    				<select id="options" name="options">
        			<option value="S" >Accept</option>
        			<option value="R" >Reject</option>
        			<option value="P" >Query</option>
    			</select>	
				</td> 
				
				</tr>
				<tr>
					<td align="center" colspan="5">
						<input type="submit" value="Submit Response"/>
					</td>
				</tr>
				
	</table>
	
	</form>
	</center>
</body>
</html>
