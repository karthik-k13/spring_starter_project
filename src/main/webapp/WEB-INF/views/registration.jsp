<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
<h2>Add registration details here:</h2>
<form action="saveReg" method="post">
<pre>
First Name <input type="text" name="firstName">
Last Name <input type="text" name="lastName">
Email <input type="email" name="email">
Mobile <input type="number" name="mobile">
City <input type="text" name="city">
State <input type="text" name="state">
Address Line<input type="text" name="addressLine">
Pin code <input type="number" name="pinCode">
<input type="submit" name="save">
</pre>
</form>
${msg}
</body>
</html>