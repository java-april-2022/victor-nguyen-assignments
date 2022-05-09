<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Your Book!</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-between mt-5 text-primary">
			<h1>Change your Entry!</h1>
			<p><a href="/books">Back to the Shelves</a></p>
		</div>
		<div>
			<form:form action="/books/${book.id}/edit" method="post" modelAttribute="book">
				<input type="hidden" name="_method" value="put"/>
				<div class="mt-3 p-5 border border-secondary border-3">
					<div class="form-group p-4 d-block">
						<form:label path="title" class="form-label text-start">Title: </form:label><br>
						<form:errors path="title" class="text-danger"/>
						<form:input path="title" type="text" class="form-control"/>
					</div>
					<div class="form-group p-4 d-block">
						<form:label path="author" class="form-label text-start">Author: </form:label><br>
						<form:errors path="author" class="text-danger"/>
						<form:input path="author" type="text" class="form-control"/>
					</div>
					<div class="form-group p-4 d-block">
						<form:label path="thoughts" class="form-label text-start">My thoughts: </form:label><br>
						<form:errors path="thoughts" class="text-danger"/>
						<form:input path="thoughts" type="text" class="form-control"/>
					</div>
					<div>
						<form:input type="hidden" path="user" value="${user.id}"/>
					</div>
					<input type="submit" value="Submit" class="btn btn-primary w-100"/>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>