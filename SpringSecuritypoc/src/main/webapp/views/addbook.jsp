<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Addbook</title>
</head>
<body class="container">
	<h1 class="text-center">PLEASE ENTER BOOK DETAILS</h1>
	<hr>
	<form:form method="POST" action="addbook" modelAttribute="bookadd">
		<div class="form-group">
			<form:label path="bookid">BOOK-ID:</form:label>
			<form:input type="number" class="form-control" path="bookid"
				placeholder="Enter Book ID" />
			<form:errors path="bookid" cssClass="error" />
		</div>

		<div class="form-group">
			<form:label path="bookname">BOOK-TITLE:</form:label>
			<form:input type="text" class="form-control" path="bookname"
				placeholder="Enter Book Title" />
			<form:errors path="bookname" cssClass="error" />
		</div>
		<div class="form-group">
			<form:label path="copies">Copies:</form:label>
			<form:input type="number" class="form-control" path="copies"
				placeholder="Enter Book Price" />
			<form:errors path="copies" cssClass="error" />
		</div>
		<div class="form-group">
			<form:label path="subject">Subject:</form:label>
			<form:input type="text" class="form-control" path="subject"
				placeholder="Enter Book Volume" />
			<form:errors path="subject" cssClass="error" />
		</div>

		<br>
		<button type="submit" class="btn btn-outline-dark">ADD BOOK</button>
		</form:form>
</body>
</html>