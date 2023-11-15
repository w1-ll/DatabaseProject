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
        <br>
       
        <br>
         <table border="1" cellpadding="6">
            <caption><h2>List of Requests</h2></caption>
            <tr>
                <th>RequestID</th>
                <th>User Email </th>
                <th>Status</th>
                <th>Note</th>
                              
            </tr>
            <c:forEach var="request" items="${Requests}">
                <tr style="text-align:center">
                    <td><c:out value="${request.requestID}" /></td>
                	<td><c:out value="${request.email}" /></td>
                    <td><c:out value="${request.status}" /></td>
                    <td><c:out value="${request.note}" /></td>
                                      
           </c:forEach>
        </table>
        
         <table border="1" cellpadding="6">
            <caption><h2>List of Quotes</h2></caption>
            <tr>
                <th>QuoteID</th>
                <th>User Email</th>
                <th>Contractor Status</th>
                <th>User Status</th>
                <th>Negotiation Note</th>
                <th>Work Period </th>
                <th>Price</th>
                <th>User note</th>
                <th>Tree ID</th>
                              
            </tr>
            
            
            <c:forEach var="quote" items="${Quotes}">
                <tr style="text-align:center">
                    <td><c:out value="${quote.quoteID}" /></td>
                    <td><c:out value="${quote.email}" /></td>
                    <td><c:out value="${quote.contractor_status}" /></td>
                    <td><c:out value="${quote.user_status}" /></td>
                    <td><c:out value="${quote.negotiation_note}" /></td>
                    <td><c:out value="${quote.work_period}" /></td>
                    <td><c:out value="${quote.price}" /></td>    
                    <td><c:out value="${quote.user_note}" /></td>    
                    <td><c:out value="${quote.tree_id}" /></td>           
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
            
            
            <c:forEach var="tree" items="${Trees}">
                <tr style="text-align:center">
                    <td><c:out value="${tree.tree_distance}" /></td>
                    <td><c:out value="${tree.trunk_size}" /></td>
                    <td><c:out value="${tree.tree_height}" /></td>
                    <td><c:out value="${tree.tree_location}" /></td>              
           </c:forEach>
        </table>
       
       
       <table border="1" cellpadding="6">
            <caption><h2>List of Bills</h2></caption>
            <tr>
                <th>Bill ID</th>
                <th>Status</th>
                <th>Negotiation Note</th>
                <th>Final Price </th>              
            </tr>
            
            
            <c:forEach var="bill" items="${Bills}">
                <tr style="text-align:center">
                    <td><c:out value="${bill.billID}" /></td>
                    <td><c:out value="${bill.status}" /></td>
                    <td><c:out value="${bill.negotiation_note}" /></td>
                    <td><c:out value="${bill.final_price}" /></td>   
           </c:forEach>
        </table>
       
       <table border="1" cellpadding="6">
            <caption><h2>List of Orders</h2></caption>
            <tr>
                <th>Order ID</th>
                <th>Status</th>
                <th>User Email</th>           
            </tr>
            
            
            <c:forEach var="order" items="${Orders}">
                <tr style="text-align:center">
                    <td><c:out value="${order.orderID}" /></td>
                    <td><c:out value="${order.status}" /></td>
                    <td><c:out value="${order.email}" /></td>  
           </c:forEach>
        </table>

	</div>
	</div>

</body>
</html>
