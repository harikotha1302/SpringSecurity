<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome User</title>
</head>
<body>
<div style="text-align:center">
<h1>Main Menu</h1>
<hr>
<h2><a href="${pageContext.request.contextPath}/library/viewbook">ListBooks</a></h2>
<br>
<h2><a href="${pageContext.request.contextPath}/library/delete">Delete Book</a></h2>
<br>
<h2><a href="${pageContext.request.contextPath}/library/searchbook">Search Book</a></h2>
<br>
 <a href="<c:url value="/logout" />">Logout</a>
</div>
</body>
</html>