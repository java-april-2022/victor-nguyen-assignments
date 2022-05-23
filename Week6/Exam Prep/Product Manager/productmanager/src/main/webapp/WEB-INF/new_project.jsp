<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a Project</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<p class="text-end mt-5"><a href="/dashboard">Back to Dashboard</a><p>
		<div class="d-flex justify-content-center mt-5">
			<h1>Create a Project</h1>
		</div>
		<br>
		<div class="d-flex justify-content-center">
			<form:form action="/projects/new" method="post" modelAttribute="project" class="w-75">
				<div class="mt-3 p-5 border border-secondary border-3 w-auto">
						<div class="form-group p-4 d-block">
							<form:label path="title" class="form-label text-start">Project Title: </form:label><br>
							<form:errors path="title" class="text-danger"/>
							<form:input path="title" type="text" class="form-control"/>
						</div>
						<div class="form-group p-4 d-block">
							<form:label path="description" class="form-label text-start">Project Description: </form:label><br>
							<form:errors path="description" class="text-danger"/>
							<form:textarea rows="4" path="description" type="text" class="form-control"/>
						</div>
						<div class="form-group p-4 d-block">
							<form:label path="dueDate" class="form-label text-start">Due Date: </form:label><br>
							<form:errors path="dueDate" class="text-danger"/>
							<form:input path="dueDate" type="date" class="form-control"/>
						</div>
						<input type="submit" value="Submit" class="btn btn-primary w-100"/>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>