<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
<div style="text-align:center">
<h1>Main Menu</h1>
<hr>
<h2><a href="${pageContext.request.contextPath}/student/searchbook">ListBooks</a></h2>
<br>
<h2><a href="${pageContext.request.contextPath}/student/viewbooks">View assigned books</a></h2>
<br>
 <a href="<c:url value="/logout" />">Logout</a>
</div>
</body>
</body>
</html>