<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Send Quote</title>
</head>
<body>
<center>
<h1>Send Quote</h1> <br>
<c:out value="${SpecificTrees}" />
        <br>
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
					<th>Request ID</th>
					<td align="center" colspan="3">
						<p>${requestID}</p>
					</td>
					
				</tr>
				
				<tr>
					<th>User Note </th>
					<td align="center" colspan="3">
						<p>${user_note}</p>
						<input type="hidden" name="user_note" value = "${user_note}">
						
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
						<input type="text" name="workPeriod" size="20" value="00" onfocus="this.value=''">
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
						<input type="text" name="price" size="20" value="00" onfocus="this.value=''">
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
					<td align="center" colspan="5">
						<input type="submit" value="Submit Quote"/>
					</td>
				</tr>
	</table>
	
	</form>
	</center>
	

  <!-- <div id="table-container"></div>

  
 -->
</center>
	
</body>
</html>
