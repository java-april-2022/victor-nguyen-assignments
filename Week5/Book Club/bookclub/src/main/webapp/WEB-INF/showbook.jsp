<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Looking at a Book...</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-between mt-5">
			<h1 class="text-info"><c:out value="${book.title}"/></h1>
			<p><a href="/books">Back to the Shelves</a></p>
		</div>
		<h3 class="mt-5">
			<span class="text-danger"><c:out value="${book.user.userName}"/></span> read <span class="text-info"><c:out value="${book.title}"/></span> by <span class="text-success"><c:out value="${book.author}"/></span>.
		</h3>
		<h4 class="mt-3">Here are <c:out value="${book.user.userName}"/>'s thoughts:</h4>
		<hr>
		<p class="text-center"><c:out value="${book.thoughts}"/></p>
		<hr>
	</div>
</body>
</html>