<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome!</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-between mt-5 text-primary">
			<h1>Welcome, <c:out value="${user.userName}"/>!</h1>
			<p><a href="/logout">Logout</a></p>
		</div>
		<div class="d-flex justify-content-between text-success">
			<h2>Books from everyone's shelves:</h2>
			<p><a href="/books/new">+ Add a book to my shelf!</a></p>
		</div>
		<table class="table table-striped border border-dark border-3">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
					<tr>
						<td><c:out value="${book.id}"/></td>
						<td><a href="/books/${book.id}"><c:out value="${book.title}"/></a>
						<td><c:out value="${book.author}"/></td>
						<td><c:out value="${book.user.userName}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/bookmarket">Would you like to check a book out?</a>
	</div>
</body>
</html>