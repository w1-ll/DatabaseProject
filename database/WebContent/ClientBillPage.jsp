<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check Bill</title>
</head>
<body>
	<center><h1>Your given Bill</h1>
	
	<table border="1" cellpadding="5">
				<tr>
					<th>Bill ID </th>
					<td align="center" colspan="3">
						<p>${billID}</p>
					</td>
				</tr>
				<tr>
					<th>Status </th>
					<td align="center" colspan="3">
						<p>${status}</p>
					</td>
				</tr>
				<tr>
					<th>Contractor Note </th>
					<td align="center" colspan="3">
						<p>${contractor_note}</p>
					</td>
				</tr>
				<tr>
					<th>Your note </th>
					<td align="center" colspan="3">
						<p>${user_note}</p>
					</td>
				</tr>
				<tr>
					<th>Amount Due </th>
					<td align="center" colspan="3">
						<p>${amt_due}</p>
					</td>
				</tr>
				<tr>
					<th>Amount Paid </th>
					<td align="center" colspan="3">
						<p>${amt_paid}</p>
					</td>
				</tr>
				
				<tr>
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
</tr>

<tr>
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

</tr>

	</table>
	<br>
	<br><br>
	
	<h2>Your response</h2>
	<table border="1" cellpadding="5">
	<form action="payment">
			<tr>
			<th>Do want to make a payment now?:</th>					
					<td align="center" colspan="5">
						<input type="hidden" name = "billID" value="${billID}">
						<input type="hidden" name = "amt_due" value="${amt_due}">
						<input type="hidden" name = "amt_paid" value="${amt_paid}">
					
						<input type="submit" value="Make a payment"/>
						
					</td>
				</tr>
				</form>
			    <form action="clientBillQueries">
				
				<tr> 
				<th>Any notes or queries?</th>
				<td align="center" colspan="3">
						<input type="text" name="note" size="100"  value="" onfocus="this.value=''">
						<input type="hidden" name = "billID" value="${billID}">
						
					</td>
				
					<td align="center" colspan="5">
						<input type="submit" value="Submit"/>
					</td>
				</tr>
					</form>
				
			

				
	</table>
	
	</center>
</body>
</html>
