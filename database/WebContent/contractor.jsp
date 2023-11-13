<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contractor page</title>
</head>

<center><h1>Welcome, David! You have been successfully logged in</h1> </center>

 
	<body>
	 <center>
		 <a href="login.jsp"target ="_self" > logout</a><br><br> 
		 <p> You can show all the transactions or other attributes here like balance, name of the user and others.</p>
		 </center>
	<div align="center">
	<h2>Current Requests:</h2>
		<c:forEach var="request" items="${Requests}">
    <form action="DirectToQuotePage" method="post">
        <table border="1" cellpadding="6">
            <!-- Table headers -->

            <tr style="text-align:center">
                <!-- Table data -->
                <td><c:out value="${request.requestID}" /></td>
                <td><c:out value="${request.email}" /></td>
                <td><c:out value="${request.status}" /></td>
                <td><c:out value="${request.note}" /></td>
                <td align="center">
                    <input type="hidden" name="selectedEmail" value="${request.email}" />
                    <input type="hidden" name="selectedRequestID" value="${request.requestID}" />
                    <input type="submit" value="Send" />
                </td>
            </tr>
        </table>
    </form>
</c:forEach>





	<center>
<!--         <form action="ContractorQuotePage" method="post">
		 <table border="1" cellpadding="6">
            <caption><h2>Current Quotes</h2></caption>
            <tr>
                <th>QuoteID</th>
                <th>User Email</th>
                <th>Your Status</th>
                <th>User Status</th>
                <th>Check</th>              
            </tr>
            
            
            <c:forEach var="quote" items="${Quotes}">
            
                <tr style="text-align:center">
                    <td><c:out value="${quote.quoteID}" /></td>
                    <td><c:out value="${quote.email}" /></td>
                    <td><c:out value="${quote.contractor_status}" /></td>
                    <td><c:out value="${quote.user_status}" /></td>
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
               <!-- </td>               
           </c:forEach>
        </table>
        </form>	--> 
        
        
        <table border="1" cellpadding="6">
    <caption><h2>Current Quotes</h2></caption>
    <tr>
        <th>QuoteID</th>
        <th>User Email</th>
        <th>Your Status</th>
        <th>User Status</th>
        <th>Check</th>
    </tr>

    <c:forEach var="quote" items="${Quotes}">
        <form action="ContractorQuotePage" method="post">
            <tr style="text-align:center">
                <td><c:out value="${quote.quoteID}" /></td>
                <td><c:out value="${quote.email}" /></td>
                <td><c:out value="${quote.contractor_status}" /></td>
                <td><c:out value="${quote.user_status}" /></td>
                <td align="center">
                    <input type="hidden" name="quoteID" value="${quote.quoteID}" />
                    <input type="hidden" name="Cstatus" value="${quote.contractor_status}" />
                    <input type="hidden" name="Ustatus" value="${quote.user_status}" />
                    <input type="hidden" name="note" value="${quote.negotiation_note}" />
                    <input type="hidden" name="work_period" value="${quote.work_period}" />
                    <input type="hidden" name="price" value="${quote.price}" />
                    <input type="hidden" name="user_note" value="${quote.user_note}" />
                    <input type="submit" value="Check Quote" />
                </td>
            </tr>
        </form>
    </c:forEach>
</table>
        
        </center>


        </div> 
	</body>
</html>
