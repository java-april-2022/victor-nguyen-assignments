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
<title>Project Details</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<p class="text-end mt-5"><a href="/dashboard">Back to Dashboard</a><p>
		<div class="d-flex justify-content-center mt-5">
			<h1>Project Details</h1>
		</div>
		<br>
		<div class="d-flex justify-content-center">
			<div class="mt-3 p-5 border border-secondary border-3 w-50">
				<div class="d-flex justify-content-around">
					<div class="w-25">
						<p class="fw-bold text-start">Project: </p>
					</div>
					<div class="w-50">
						<p class="text-start">Project: <c:out value="${project.title}"></c:out></p>
					</div>
				</div>
				<div class="d-flex justify-content-around">
					<div class="w-25">
						<p class="fw-bold text-start">Description: </p>
					</div>
					<div class="w-50">
						<p class="text-start">Description: <c:out value="${project.description}"></c:out></p>
					</div>
				</div>
				<div class="d-flex justify-content-around">
					<div class="w-25">
						<p class="fw-bold text-start">Due Date: </p>
					</div>
					<div class="w-50">
						<p class="text-start"><fmt:formatDate value="${project.dueDate}" pattern="MMMM dd"/></p>
					</div>
				</div>
			</div>
		</div>
		<p><a href="/projects/${project.id}/tasks">See Tasks</a><p>
		<div class="d-flex justify-content-end">
			<c:if test = "${project.lead.id==userId}">
    			<a href="/projects/delete/${project.id}" class="btn btn-danger">Delete Project</a>
			</c:if>
		</div>
	</div>
</body>
</html>