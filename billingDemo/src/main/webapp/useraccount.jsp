<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Account</title>
</head>
<body>
	<table>
	<c:forEach var="bill" items="${billDetails}">
	
	<tr>
		<td>Bill ID</td>
		<td>${bill.bID}</td>td>
	</tr>
	<tr>
		<td>Customer ID</td>
		<td>${bill.cID}</td>
	</tr>
	<tr>
		<td>Customer Name</td>
		<td>${bill.name}</td>
	</tr>
	<tr>
		<td>Customer Phone</td>
		<td>${bill.phone}</td>
	</tr>
	<tr>
		<td>Units</td>
		<td>${bill.units}</td>
	</tr>
	<tr>
		<td>Bill</td>
		<td>${bill.bill}</td>
	</tr>
	<tr>
		<td>User Name</td>
		<td>${bill.userName}</td>
	</tr>
	<tr>
		<td>User Password</td>
		<td>${bill.password}</td>
	</tr>
		
	</c:forEach>
	</table>

</body>
</html>