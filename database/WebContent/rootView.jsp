<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>


<head>
<meta charset="ISO-8859-1">
<title>Root page</title>
</head>
<body>

<div align = "center">
	
	<form action = "initialize">
		<input type = "submit" value = "Initialize the Database"/>
	</form>
	<a href="login.jsp"target ="_self" > logout</a><br><br> 

<h1>List all users</h1>
    <div align="center">
        <table border="1" cellpadding="6">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>Email</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Adress</th>
                <th>Password</th>
                <th>Phone Number</th>
                <th>credit card information</th>
               
            </tr>
            <c:forEach var="users" items="${listUser}">
                <tr style="text-align:center">
                    <td><c:out value="${users.email}" /></td>
                    <td><c:out value="${users.firstName}" /></td>
                    <td><c:out value="${users.lastName}" /></td>
                    <td><c:out value= "${users.adress_street_num} ${users.adress_street} ${users.adress_city} ${users.adress_state} ${users.adress_zip_code}" /></td>
                    <td><c:out value="${users.password}" /></td>
                    <td><c:out value="${users.phone_number}" /></td>
                    <td><c:out value="${users.creditcard_information}"/></td>
                  
           </c:forEach>
        </table>
        
         <table border="1" cellpadding="6">
            <caption><h2>List of Requests</h2></caption>
            <tr>
                <th>RequestID</th>
                <th>Status</th>
                <th>Note</th>
                              
            </tr>
            <c:forEach var="request" items="${Requests}">
                <tr style="text-align:center">
                    <td><c:out value="${request.requestID}" /></td>
                    <td><c:out value="${request.status}" /></td>
                    <td><c:out value="${request.note}" /></td>
                                      
           </c:forEach>
        </table>
        
         <table border="1" cellpadding="6">
            <caption><h2>List of Quotes</h2></caption>
            <tr>
                <th>QuoteID</th>
                <th>Status</th>
                <th>Negotiation Note</th>
                <th>Work Period </th>
                <th>Price</th>
                              
            </tr>
            
            
            <c:forEach var="quote" items="${Quotes}">
                <tr style="text-align:center">
                    <td><c:out value="${quote.quoteID}" /></td>
                    <td><c:out value="${quote.status}" /></td>
                    <td><c:out value="${quote.negotiation_note}" /></td>
                    <td><c:out value="${quote.work_period}" /></td>
                    <td><c:out value="${quote.price}" /></td>                
           </c:forEach>
        </table>

	<table border="1" cellpadding="6">
            <caption><h2>Tree Table</h2></caption>
            <tr>
                <th>Tree Distance</th>
                <th>Trunk Size</th>
                <th>Tree Height</th>
                <th>Tree Location </th>              
            </tr>
            
            
            <c:forEach var="Trees" items="${Trees}">
                <tr style="text-align:center">
                    <td><c:out value="${tree.treeDistance}" /></td>
                    <td><c:out value="${tree.trunkSize}" /></td>
                    <td><c:out value="${tree.treeHeight}" /></td>
                    <td><c:out value="${tree.treeLocation}" /></td>              
           </c:forEach>
        </table>

	<table border="1" cellpadding="6">
            <caption><h2>List of bills</h2></caption>
            <tr>
                <th>BillID</th>
                <th>Initial Price</th>
                <th>Bargained Price</th>
                <th>Final Price </th>
                              
            </tr>
            
            
            <c:forEach var="Bill" items="${Bill}">
                <tr style="text-align:center">
                    <td><c:out value="${Bill.billID}" /></td>
                    <td><c:out value="${Bill.initialPrice}" /></td>
                    <td><c:out value="${Bill.priceBargain}" /></td>
                    <td><c:out value="${Bill.finalPrice}" /></td>              
           </c:forEach>
        </table>
        
	</div>
	</div>

</body>
</html>
