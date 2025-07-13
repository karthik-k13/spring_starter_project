<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Update Registration</title>
</head>
<body>
<h2>Update registration details here:</h2>
<form action="updateRegistration" method="post">
<pre>
<input type="hidden" name="id" value="${emp.id}">
First Name <input type="text" name="firstName" value="${emp.firstName}">
Last Name <input type="text" name="lastName" value="${emp.lastName}">
Email <input type="email" name="email" value="${emp.email}">
Mobile <input type="number" name="mobile" value="${emp.mobile}">
<input type="submit" name="update">
</pre>
</form>
${msg}
</body>
</html>