<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><title>Registration</title></head>
<body>
	<div align="center">
		<p> ${errorOne } </p>
		<p> ${errorTwo } </p>
		<form action="register">
			<table border="1" cellpadding="5">
				<tr>
					<th>User name: </th>
					<td align="center" colspan="3">
						<input type="text" name="email" size="45"  value="example@gmail.com" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>First Name: </th>
					<td align="center" colspan="3">
						<input type="text" name="firstName" size="45" value="FirstName" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Last Name: </th>
					<td align="center" colspan="3">
						<input type="text" name="lastName" size="45" value="LastName" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Phone number: </th>
					<td align="center" colspan="3">
						<input type="text" name="phone_number" size="45" value="(xxx)-xxx-xxxx" onfocus="this.value=''">
					</td>
	
				</tr>
				<tr>
				<tr>
					<th>Credit card information: </th>
					<td align="center" colspan="3">
						<input type="text" name="creditcard_information" size="45" value="xxxxxxxxxxxxxxxx" onfocus="this.value=''">
					</td>
	
				</tr>
				<tr>
					<th>Password: </th>
					<td align="center" colspan="3"> 
						<input type="password" name="password" size="45" value="password" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Password Confirmation: </th>
					<td align="center" colspan="3">
						<input type="password" name="confirmation" size="45" value="password" onfocus="this.value=''">
					</td>
				
				</tr>
				<tr>
					<td align="center" colspan="5">
						<input type="submit" value="Register"/>
					</td>
				</tr>
			</table>
			<a href="login.jsp" target="_self">Return to Login Page</a>
		</form>
	</div>
</body>