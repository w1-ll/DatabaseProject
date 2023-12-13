<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
					<th>Finish Date</th>
					<td align="center" colspan="3">
						<p>${finish_date}</p>
					</td>
				</tr>
				
	</table>
	
	<table border="1" cellpadding="6">
    <caption><h2>Tree Details:</h2></caption>
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
	</center>
</body>
</html>
