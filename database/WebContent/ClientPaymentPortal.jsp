<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Client Payment Portal</title>
</head>
<body>
<center>
<form action="finishPayment">

	<h1>Client Payment Portal:</h1>
	<table border="1" cellpadding="5">
				<tr>
					<th>Bill ID</th>
					<td align="center" colspan="3">
						<p>${billID}</p>
						
					</td>
				</tr>
								
				<tr>
					<th>Amount Due</th>
					<td align="center" colspan="3">
						<p>${amt_due}</p>
					</td>
				</tr>
				<tr>
					<th>Amount Paid</th>
					<td align="center" colspan="3">
						<p>${amt_paid}</p>
						<input type="hidden" name="email" value = "${email}">
						<input type="hidden" name="billID" value = "${billID}">
						<input type="hidden" name="amt_due" value = "${amt_due}">
						<input type="hidden" name="amt_paid" value = "${amt_paid}">
						
						
						
					</td>
				</tr>
				<tr>
					<th>How much do you want to pay?</th>
					<td align="center" colspan="3">
						<input type="text" name="payment" size="10" value="00"">
						
					</td>
				</tr>
				<tr>
				<td align="center" colspan="5">
						<input type="submit" value="Make Payment"/>
					</td>
				</tr>
				
				</table>
				
				</form>
				
				
				
</center>
</body>
</html>
