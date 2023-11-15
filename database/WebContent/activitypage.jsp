<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Activity page</title>
</head>



 
	<body>
	 <center><h1>Welcome Client! You have been successfully logged in</h1> </center>
	 
	 <center>
	 
		 <a href="login.jsp"target ="_self" > logout</a><br><br> 
		 <p> You can show all the transactions or other attributes here like balance, name of the user and others.</p>
		 <!-- <input type="submit" value="Start a new Request" /> -->
		 
		 <form action="SendToRequestPage" method="post">
		 <!--<center><a href="ClientRequest.jsp"target ="_self" > Start a new Request</a></center><br><br> -->
		 <!-- <center><button type="button"> Start a new Request</button></center><input type="submit" value="Start a new Request"/> -->
		 <input type="submit" value="Start a new Request" /> 
		 </form>
		 </center>
		 <center>
		 <table border="1" cellpadding="6">
            <caption><h2>Your Requests</h2></caption>
            <tr>
                <th>RequestID</th>
                <th>Status</th>
                              
            </tr>
            <c:forEach var="request" items="${specificRequest}">
                <tr style="text-align:center">
                    <td><c:out value="${request.requestID}" /></td>
                    <td><c:out value="${request.status}" /></td>
                                      
           </c:forEach>
        </table>
        </center>
        
        <center>
		 <table border="1" cellpadding="6">
            <caption><h2>Your Quotes</h2></caption>
            <tr>
                <th>QuoteID</th>
                <th>Contractor Status</th>
                <th>Your Status</th>
                <th>Contractor Note</th>
                <th>Work Period </th>
                <th>Price</th>
                <th>Check</th>              
            </tr>
            
            
            <c:forEach var="quote" items="${specificQuote}">
            <form action="ClientQuotePage" method="post">
            
                <tr style="text-align:center">
                    <td><c:out value="${quote.quoteID}" /></td>
                    <td><c:out value="${quote.contractor_status}" /></td>
                    <td><c:out value="${quote.user_status}" /></td>
                    <td><c:out value="${quote.negotiation_note}" /></td>
                    <td><c:out value="${quote.work_period}" /></td>
                    <td><c:out value="${quote.price}" /></td> 
                    <td align="center">
                    <input type="hidden" name="quoteID" value="${quote.quoteID}" />
                    <input type="hidden" name="Cstatus" value="${quote.contractor_status}" />
                    <input type="hidden" name="Ustatus" value="${quote.user_status}" />
                    <input type="hidden" name="note" value="${quote.negotiation_note}" />
                    <input type="hidden" name="work_period" value="${quote.work_period}" />
                    <input type="hidden" name="price" value="${quote.price}" />
                    <input type="hidden" name="user_note" value="${quote.user_note}" />
                     <input type="submit" value="Check Quote" /> 
                    <!--<center><a href="ClientRequest.jsp"target ="_self" > Check Quote </a></center>-->
                </td>   
                </tr>
                 </form>            
           </c:forEach>
        </table>
       	
        
        
        <table border="1" cellpadding="6">
            <caption><h2>Your Orders</h2></caption>
            <tr>
                <th>OrderID</th>
                <th>Status</th>
                <th>Check</th>
                              
            </tr>
            
            
            <c:forEach var="order" items="${specificOrder}">
            <form action="ClientOrderPage" method="post">
            
                <tr style="text-align:center">
                    <td><c:out value="${order.orderID}" /></td>
                    <td><c:out value="${order.status}" /></td>
                    <td align="center">
                    <input type="hidden" name="orderID" value="${order.orderID}" />
                    <input type="hidden" name="status" value="${order.status}" />
                     <input type="submit" value="Check Order" /> 
                    <!--<center><a href="ClientRequest.jsp"target ="_self" > Check Quote </a></center>-->
                </td>   
                </tr>
                 </form>            
           </c:forEach>
        </table>
    </center>   	
	</body>
</html>
