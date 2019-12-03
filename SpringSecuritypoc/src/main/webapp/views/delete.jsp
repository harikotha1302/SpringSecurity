<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Select book to <strong>Delete</strong></h1>
<table border="1" >

<tr>
			<th>ID</th>
			<th>TITLE</th>
			<th>PRICE</th>
			<th>VOLUME</th>
			<th>DATE</th>
			<th>DELETE</th>
		</tr>
		<c:if test="${empty booklist}">
			<tr>
				<td colspan="11" align="center">No record found to display.</td>
			</tr>
		</c:if>
	<c:forEach var="bks" items="${books}">
			<tr>
				<td>${bks.bookid}</td>
				<td>${bks.bookname}</td>
				<td>${bks.subject}</td>
				<td>${bks.copies}</td>
				<td><a href="${pageContext.request.contextPath}/deletebook?bookid=${bks.bookid}">Delete</a></td>
			</tr>
	</c:forEach>
</table>
<br>
<a href="${contextPath}addbook">ADD BOOK</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="${contextPath}/">MAIN MENU</a>

</body>
</html>