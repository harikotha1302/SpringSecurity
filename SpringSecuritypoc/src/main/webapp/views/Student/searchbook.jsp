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
	
	<button>Search</button>

</form>
</div>

<table border="1" align="center">
<tr>
	<th>Book_Id</th>
	<th>Book_name</th>
	<th>Subject</th>
	<th>Copies</th>
</tr>
<tr>
<c:if test="${empty books}">
	<td colspan="11" align="center">No record found to display.</td>
</c:if></tr>
<c:forEach var="book" items="${books}">
	<tr>
	<td>${book.bookid}</td>
	<td>${book.bookname}</td>
	<td>${book.subject}</td>
	<td>${book.copies}</td>
	<td><a href="${pageContext.request.contextPath}/library/viewuser?bookid=${book.bookid}">Allotted Student List</a></td>
	</tr>
	</c:forEach>
</table>
<br>
<div align="center" >
<a href="${pageContext.request.contextPath}/library/addbook">Add Book</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/library">Main Menu</a></div>

</body>
</html>