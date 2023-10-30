<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Activity page</title>
</head>

<center><h1>Welcome Client! You have been successfully logged in</h1> </center>

 
	<body>
	
	 <center>
		 <a href="login.jsp"target ="_self" > logout</a><br><br> 
		 <p> You can show all the transactions or other attributes here like balance, name of the user and others.</p>
		 </center>
		 
		 <center><a href="ClientRequest.jsp"target ="_self" > Start a new Request</a></center><br><br> 
		 <!-- <center><button type="button"> Start a new Request</button></center><input type="submit" value="Start a new Request"/> -->
		
	</body>
</html>
