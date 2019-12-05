<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SearchBook</title>
</head>
<body>
<h2>Search book</h2>
<div align="center">
<form action="searchbook" method="post">
	<select name="searchby">
	<option value="id">Search by Id</option>
	<option value="subject">Search By Subject</option>
	</select>&nbsp;&nbsp;
	<input type="text" name="searchvalue" required="required" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<button>Search</button>

</form>
</div>
<form action="viewbookassigned" method="post" >
<table border="1" align="center">
<tr>
	<th>Book_Id</th>
	<th>Book_name</th>
	<th>Subject</th>
	<th>Copies</th>
	<th>AssignStatus</th>
</tr>
<tr>
<c:if test="${empty userbook}">
	<td colspan="11" align="center">No record found to display.</td>
</c:if></tr>
<c:forEach var="userbook" items="${userbook}">
	<tr>
	<td>${userbook.b.bookid}</td>
	<td>${userbook.b.bookname}</td>
	<td>${userbook.b.subject}</td>
	<td>${userbook.b.copies}</td>
	
	<c:if test="${userbook.b.copies==0 }">
	<td>No books available for booking</td>
	</c:if>
	<c:if test="${userbook.isAssigned }">
	<td>book is already assigned to you</td>
	</c:if>
	<td>
		<input type="checkbox" name="assign" value="${userbook.b.bookid}">AssignBook
	</td>
	</tr>
	</c:forEach>
</table>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<button>submit</button>
</form>
<br>
<div align="center" >
<a href="${pageContext.request.contextPath}/student/viewbook">View Books</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/student">Main Menu</a></div>

</body>
</html>