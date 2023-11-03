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
        </div> 
	</body>
</html>
