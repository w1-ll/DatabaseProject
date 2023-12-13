<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
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
	<table border="1" cellpadding="6">
    <caption><h2>Tree Table</h2></caption>
    <tr>
        <th>Tree Distance</th>
        <th>Trunk Size</th>
        <th>Tree Height</th>
        <th>Tree Location</th>
    </tr>

    <c:forEach var="tree" items="${SpecificTrees}">
        <tr style="text-align:center">
            <td><c:out value="${tree.tree_distance}" /></td>
            <td><c:out value="${tree.trunk_size}" /></td>
            <td><c:out value="${tree.tree_height}" /></td>
            <td><c:out value="${tree.tree_location}" /></td>
        </tr>
    </c:forEach>
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
						<!--  <p>${tree_id }</p>-->
					</td>
				</tr>
				
				</tr>
		
			<table border="1" cellpadding="6">
    <caption><h2>Messages</h2></caption>
    <tr>
        <th>Sender</th>
        <th>Recipient</th>
        <th>Message Content</th>
        <th>Date and Time</th>
    </tr>

    <c:forEach var="message" items="${SpecificMessages}">
        <tr style="text-align:center">
            <td><c:out value="${message.sender}" /></td>
            <td><c:out value="${message.recipient}" /></td>
            
            <td><c:out value="${message.message_content}" /></td>
            <td><c:out value="${message.time_stamp}" /></td>
        </tr>
    </c:forEach>
</table>		
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
	</br>

</table>
<br>

	</form>
	</center>
	
	
</body>
</html>
