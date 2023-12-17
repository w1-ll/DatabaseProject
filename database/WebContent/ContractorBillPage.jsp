<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill information</title>
</head>
<body>
<form action="reviseBill">
	<center><h1>Bill Information</h1>
	
	<h2>Your given Bill</h2>
	<table border="1" cellpadding="5">
				<tr>
					<th>Bill ID </th>
					<td align="center" colspan="3">
						<p>${billID}</p>
						<input type="hidden" name="billID" value="${billID}">
						<input type="hidden" name = "email" value="${email}">
						


					</td>
				</tr>
								
				<tr>
					<th> Status </th>
					<td align="center" colspan="3">
						<p>${status}</p>
					</td>
				</tr>
				<tr>
					<th>Your Note</th>
					<td align="center" colspan="3">
						<p>${contractor_note}</p>
					</td>
				</tr>
				
				<tr>
					<th>Amount Due </th>
					<td align="center" colspan="3">
						<p>${amt_due}</p>
						<input type="hidden" name = "amt_due" value="${amt_due}">
					</td>
				</tr>
				
				<tr>
					<th>Amount Paid </th>
					<td align="center" colspan="3">
						<p>${amt_paid}</p>
						<input type="hidden" name = "amt_paid" value="${amt_paid}">
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
			<th><input type="text" name="contractor_note" size="45"  value="" onfocus="this.value=''"></th>
			
		</tr>
		<tr>
			<th>Increase/Decrease due amount (insert (-) before number if you want to decrease due amount): </th>
			<th><input type="text" name="price2" size="45"  value="0" onfocus="this.value=''"></th>
		</tr>
		
		<tr> 
					
				<td align="center" colspan="3">
					<label for="options">Do you want to make any changes?:</label>
    				<select id="options" name="options">
        			<option value="S" >Yes</option>
        			<option value="R" >No</option>
    			</select>	
				</td> 
				
				</tr>
				<tr>
					<td align="center" colspan="5">
						<input type="submit" value="Submit Revised Bill"/>
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
