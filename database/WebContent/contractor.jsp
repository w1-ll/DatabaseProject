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
<table border="1" cellpadding="6">
    <caption><h2>Current Requests</h2></caption>
    <tr>
        <th>RequestID</th>
        <th>User Email</th>
        <th>Status</th>
        <th>Note</th>
        <th>Check</th>
    </tr>

    <c:forEach var="request" items="${Requests}">
        <form action="DirectToQuotePage" method="post">
            <tr style="text-align:center">
                <td><c:out value="${request.requestID}" /></td>
                <td><c:out value="${request.email}" /></td>
                <td><c:out value="${request.status}" /></td>
                <td><c:out value="${request.note}" /></td>
                <td align="center">
                    <input type="hidden" name="selectedEmail" value="${request.email}" />
                    <input type="hidden" name="selectedRequestID" value="${request.requestID}" />
                    <input type="submit" value="Send Response" />
                </td>
            </tr>
        </form>
    </c:forEach>
</table>

        
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
        

<table border="1" cellpadding="6">
            <caption><h2>Pending Orders</h2></caption>
            <tr>
                <th>Order ID</th>
                <th>Status</th>
                <th>User Email</th>
                <th>Finish Date</th>   
                <th>Check</th>        
            </tr>
            
            
            <c:forEach var="order" items="${Orders}">
            <form action="CheckOrder" method="post">
            
                <tr style="text-align:center">
                    <td><c:out value="${order.orderID}" /></td>
                    <input type="hidden" name="orderID" value="${order.orderID}" />                    
                    <td><c:out value="${order.status}" /></td>
                    <input type="hidden" name="status" value="${order.status}" />
                    
                    <td><c:out value="${order.email}" /></td> 
                    <input type="hidden" name="email" value="${order.email}" />
                    <td><c:out value="${order.finish_date}" /></td> 
                    <input type="hidden" name="finish_date" value="${order.finish_date}" />
                    
                    <td><input type="submit" value="Check Order" /> </td>
                    </tr>
                    </form>
           </c:forEach>
        </table>


<table border="1" cellpadding="6">
            <caption><h2>Pending Bills</h2></caption>
            <tr>
                <th>Bill ID</th>
                <th>Status</th>
                <th>User Note</th>
                 <th>Contractor Note</th>       
                
                <th>Amount Due</th>   
                <th>Amount Paid</th> 
                <th>Check Bill</th>  
                     
            </tr>
            
            
            <c:forEach var="bills" items="${Bills}">
            <form action="CheckBill" method="post">
            
                <tr style="text-align:center">
                    <td><c:out value="${bills.billID}" /></td>
                    <td><c:out value="${bills.status}" /></td>
                    
                    <td><c:out value="${bills.user_note}" /></td> 
                    <td><c:out value="${bills.contractor_note}" /></td> 
                  
                    <td><c:out value="${bills.amt_due}" /></td> 
                    <td><c:out value="${bills.amt_paid}" /></td> 
                    <input type="hidden" name="billID" value="${bills.billID}" />
                    <input type="hidden" name="status" value="${bills.status}" />
                    <input type="hidden" name="user_note" value="${bills.user_note}" />
                     <input type="hidden" name="contractor_note" value="${bills.contractor_note}" />
                    
                    <input type="hidden" name="amt_due" value="${bills.amt_due}" />
                    <input type="hidden" name="amt_paid" value="${bills.amt_paid}" />
                    <input type="hidden" name="unique_tree_id" value="${bills.unique_tree_id}" />
                    
                    
                    
                    
                    <td><input type="submit" value="Check Bill" /> </td>
                    </tr>
                    </form>
           </c:forEach>
        </table>
        
        

<table border="1" cellpadding="6">
    <caption><h2>Successful Requests</h2></caption>
    <tr>
        <th>RequestID</th>
        <th>User Email</th>
        <th>Status</th>
        <th>Note</th>
        <th>Check</th>
    </tr>

    <c:forEach var="request" items="${SuccessfulRequests}">
        <form action="DirectToQuotePage" method="post">
            <tr style="text-align:center">
                <td><c:out value="${request.requestID}" /></td>
                <td><c:out value="${request.email}" /></td>
                <td><c:out value="${request.status}" /></td>
                <td><c:out value="${request.note}" /></td>
                <td align="center">
                    <input type="hidden" name="selectedEmail" value="${request.email}" />
                    <input type="hidden" name="selectedRequestID" value="${request.requestID}" />
                    <input type="submit" value="Send Response" />
                </td>
            </tr>
        </form>
    </c:forEach>
</table>


<table border="1" cellpadding="6">
    <caption><h2>Successful Quotes</h2></caption>
    <tr>
        <th>QuoteID</th>
        <th>User Email</th>
        <th>Your Status</th>
        <th>User Status</th>
        <th>Check</th>
    </tr>

    <c:forEach var="quote" items="${SuccessfulQuotes}">
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




<table border="1" cellpadding="6">
    <caption><h2>Rejected Requests</h2></caption>
    <tr>
        <th>RequestID</th>
        <th>User Email</th>
        <th>Status</th>
        <th>Note</th>
        <th>Check</th>
    </tr>

    <c:forEach var="request" items="${RejectedRequests}">
        <form action="DirectToQuotePage" method="post">
            <tr style="text-align:center">
                <td><c:out value="${request.requestID}" /></td>
                <td><c:out value="${request.email}" /></td>
                <td><c:out value="${request.status}" /></td>
                <td><c:out value="${request.note}" /></td>
                <td align="center">
                    <input type="hidden" name="selectedEmail" value="${request.email}" />
                    <input type="hidden" name="selectedRequestID" value="${request.requestID}" />
                    <input type="submit" value="Send Response" />
                </td>
            </tr>
        </form>
    </c:forEach>
</table>

<table border="1" cellpadding="6">
    <caption><h2>Rejected Quotes</h2></caption>
    <tr>
        <th>QuoteID</th>
        <th>User Email</th>
        <th>Your Status</th>
        <th>User Status</th>
        <th>Check</th>
    </tr>

    <c:forEach var="quote" items="${RejectedQuotes}">
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


        </div> 
	</body>
</html>
