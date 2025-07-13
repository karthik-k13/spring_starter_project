<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="menu.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Details</title>
</head>
<body>
	<h2>Registration Details</h2>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<c:forEach var="emp" items="${emp}">
			<tr>
				<td>${emp.firstName}</td>
				<td>${emp.lastName}</td>
				<td>${emp.email}</td>
				<td>${emp.mobile}</td>
				<td><a href="deleteRegistration?id=${emp.id}">Delete</a></td>
				<td><a href="getEmployeeDetailsById?id=${emp.id}">Update</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>