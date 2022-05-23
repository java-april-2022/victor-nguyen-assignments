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
<title>Project Manager Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-between mt-5 text-primary">
			<h2>Hello, <c:out value="${user.firstName}"/>! Welcome to...</h2>
			<p><a href="/logout">Logout</a></p>
		</div>
		<div class="d-flex justify-content-between mt-5">
			<p>All Projects</p>
			<a href="/projects/new" class="btn btn-primary">+ new project</a>
		</div>
		<hr>
		<table class="table table-striped border border-dark border-3">
			<thead>
				<tr>
					<td>Project</td>
					<td>Team Lead</td>
					<td>Due Date</td>
					<td>Actions</td>
				</tr>
			</thead>
		    <tbody>
				<c:forEach var="project" items="${unassignedProjects}">
					<tr>
						<c:if test = "${project.lead.id!=user.id}">
						<td><a href="/projects/${project.id}">${project.title}</a></td>
						<td><c:out value="${project.lead.firstName}"></c:out></td>
						<td><fmt:formatDate value="${project.dueDate}" pattern="MMMM dd"/></td>
		    			<td><a href="/dashboard/join/${project.id}">Join Team</a></td>
		    			</c:if>
					</tr>	
				</c:forEach>
		    </tbody>
		</table>
		<p>Your Projects</p>
		<hr>
		<table class="table table-striped border border-dark border-3">
			<thead>
				<tr>
		    		<th>Project</th>
		    		<th>Team Lead</th>
		    		<th>Due Date</th>
		    		<th>Actions</th>
				</tr>
			</thead>
		    <tbody>
				<c:forEach var="project" items="${assignedProjects}">
						<tr>
							<td><a href="/projects/${project.id}">${project.title}</a></td>
							<td><c:out value="${project.lead.firstName}"></c:out></td>
							<td><fmt:formatDate value="${project.dueDate}" pattern="MMMM dd"/></td>
							<c:if test = "${project.lead.id==user.id}">
						       <td><a href="/projects/edit/${project.id}">Edit Project</a></td>
						    </c:if>
						    <c:if test = "${project.lead.id!=user.id}">
						       <td><a href="/dashboard/leave/${project.id}">Leave Team</a></td>
						    </c:if>
						</tr>	
				</c:forEach>
		    </tbody>
		</table>
	</div>
</body>
</html>