<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserList</title>
</head>
<body>
<h4>List of students allocated by book</h4>
<table border="1" align="center">
<tr>
	<th>User_ID</th>
	<th>User_name</th>
</tr>
<tr>
<c:if test="${empty user}">
	<td colspan="11" align="center">No record found to display.</td>
</c:if></tr>
	<c:forEach var="user" items="${user}">
	<tr>
	<td>${user.userid}</td>
	<td>${user.username}</td>
	</tr>
	</c:forEach>

</table>

<br>
<div align="center" >
<a href="${pageContext.request.contextPath}/library/viewbook">Back To book List</a></div>
</body>
</html>