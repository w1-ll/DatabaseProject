<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quote information</title>
</head>
<body>
	<center><h1>Quote Information</h1>
	
	<h2>Your given Quote</h2>
	<form action="ReviseQuote">
	<table border="1" cellpadding="5">
				<tr>
					<th>Quote ID </th>
					<td align="center" colspan="3">
						<p>${quoteID}</p>
						
					</td>
				</tr>
								
				<tr>
					<th>Your Status </th>
					<td align="center" colspan="3">
						<p>${Contractor_status}</p>
					</td>
				</tr>
				<tr>
					<th>Your Note </th>
					<td align="center" colspan="3">
						<p>${Contractor_note}</p>
					</td>
				</tr>
				
				<tr>
					<th>Work Period </th>
					<td align="center" colspan="3">
						<p>${work_period}</p>
					</td>
				</tr>
				
				<tr>
					<th>Price </th>
					<td align="center" colspan="3">
						<p>${price}</p>
						<input type="hidden" name = "price" value="${price}">
					</td>
				</tr>
	</table>
	<h2>Tree Details: </h2>
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
					<th>Tree Location</th>
					<td align="center" colspan="3">
						<p>${tree_location}</p>
					</td>
				</tr>
				
				
	</table>
	
	<h2>User Response: </h2>
	<table border="1" cellpadding="5">
				<tr>
					<th>User Status </th>
					<td align="center" colspan="3">
						<p>${user_status}</p>
						<input type = "hidden" name="user_status" value="${user_status}"/>
						<input type = "hidden" name="tree_id" value="${tree_id}"/>
						<input type = "hidden" name="email" value="${email}"/>
					</td>
				</tr>
				<tr>
					<th>User Note </th>
					<td align="center" colspan="3">
						<p>${user_note}</p>
						<p>${tree_id }</p>
					</td>
				</tr>
				
				</tr>
				
	</table>
	
	<h2>Your response: </h2>
	<table border="1" cellpadding="5">
		<tr>
			<th>Note </th>
			<th><input type="text" name="Contractor_note" size="45"  value="Enter your queries" onfocus="this.value=''"></th>
			
		</tr>
		<tr>
			<th>Price Changes: </th>
			<th><input type="text" name="price2" size="45"  value="" onfocus="this.value=''"></th>
			<input type="hidden" name = "quoteID" value="${quoteID}">
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
						<input type="submit" value="Submit Revised Quote"/>
					</td>
				</tr>
	</table>
	</form>
	</center>
	<br>
	
</body>
</html>
