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
<title>Props Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="bg-secondary">
	<div class="container">
		<p class="text-end mt-5"><a href="/dashboard" class="btn btn-info">Back to Dashboard</a><p>
		<div class="d-flex justify-content-start mt-5">
			<h1>Project: ${project.title}</h1>
		</div>
		<p class="mt-3">Project Lead: ${project.lead.firstName}</p>
		<br>
		<form:form action="/projects/${project.id}/tasks" method="post" modelAttribute="task">
			<div class="form-group p-4 d-flex">
				<form:label path="taskTicket" class="form-label text-center align-self-center w-25">Add a task ticket for this team:</form:label><br>
				<form:errors path="taskTicket" class="text-danger"/>
				<form:textarea rows="4" class="input w-50 ms-5" path="taskTicket"/>
			</div>
				<div class="d-flex justify-content-end">
					<input type="submit" value="Submit" class="btn btn-info"/>
				</div>
		</form:form>
		<hr>
		<c:forEach var="task" items="${tasks}">
			<h4>Added by <c:out value="${task.creator.firstName}"></c:out> at <fmt:formatDate value="${task.createdAt}" pattern="h:mm a MMMM dd"/>:</h4>
			<p class="m-4"><c:out value="${task.taskTicket}"></c:out></p>
		</c:forEach>
	</div>
</body>
</html>