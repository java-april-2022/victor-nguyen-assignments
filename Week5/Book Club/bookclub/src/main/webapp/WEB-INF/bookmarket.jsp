<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Broker Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-between mt-5 text-primary">
			<h2>Hello, <c:out value="${user.userName}"/>! Welcome to...</h2>
			<div>
				<p><a href="/logout">Logout</a></p>
				<p><a href="/books">Back to the Shelves</a></p>
			</div>
		</div>
		<h1 class="text-success">The Book Broker!</h1>
		<p>Available books to borrow</p>
		<hr>
		<table class="table table-striped border border-dark border-3">
			<thead>
				<tr>
					<td>ID</td>
					<td>Title</td>
					<td>Author Name</td>
					<td>Owner</td>
					<td>Actions</td>
				</tr>
			</thead>
		    <tbody>
				<c:forEach var="book" items="${books}">
					<tr>
						<td><c:out value="${book.id}"></c:out></td>
						<td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
						<td><c:out value="${book.author}"></c:out></td>
						<td><c:out value="${book.user.userName}"></c:out></td>
						<c:if test = "${book.user.id==user.id}">
					       <td><a href="/books/${book.id}/edit">edit</a> <a href="/books/delete/${book.id}">delete</a></td>
					    </c:if>
						<c:if test = "${book.user.id!=user.id}">
					       <td><a href="/bookmarket/${book.id}">borrow</a></td>
					    </c:if>
					</tr>	
				</c:forEach>
		    </tbody>
		</table>
		<p>Books I'm borrowing..</p>
		<hr>
		<table class="table table-striped border border-dark border-3">
			<thead>
				<tr>
					<td>ID</td>
					<td>Title</td>
					<td>Author Name</td>
					<td>Owner</td>
					<td>Actions</td>
				</tr>
			</thead>
		    <tbody>
				<c:forEach var="book" items="${myBooks}">
					<tr>
						<td><c:out value="${book.id}"></c:out></td>
						<td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
						<td><c:out value="${book.author}"></c:out></td>
						<td><c:out value="${book.user.userName}"></c:out></td>
						<td><a href="/bookmarket/return/${book.id}">return</a></td>
					</tr>	
				</c:forEach>
		    </tbody>
		</table>
	</div>
</body>
</html>