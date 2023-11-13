<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Send Quote</title>
</head>
<body>
<h1>Send Quote</h1> <br>
	<form action="sendQuote">
	<table border="1" cellpadding="5">
				<tr> 
				<th>Email Address</th>
				<td align="center" colspan="3">
						<p>${emailID}</p>
						<input type="hidden" name="selectedEmail" value="${emailID}">
						<input type = "hidden" name = "selectedRequestID" value="${requestID}">
					</td>
				 
				
				</tr>
				<tr>
					<th>Quote ID </th>
					<td align="center" colspan="3">
						<p>${quoteID}</p>
						<input type="hidden" name="quoteID" value = "${quoteID}">
					</td>
					
				</tr>
				
				
				<tr> 
				<th>Your status</th>
				<td align="center" colspan="3">
					
					<label for="options"></label>
    				<select id="options" name="options">
        			<option value="S" >Accept</option>
        			<option value="R" >Reject</option>
        			<option value="P" >Query</option>
    			</select>	
				</td> 
				
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
					<th>Total Cost </th>
					<td align="center" colspan="3">
						<input type="text" name="price" size="20" value="Enter the quote price" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="5">
						<input type="submit" value="Submit Quote"/>
					</td>
				</tr>
	</table>
	
	</form>
</body>
</html>
