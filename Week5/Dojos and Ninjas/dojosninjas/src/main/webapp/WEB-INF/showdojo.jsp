<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Dojos</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="text-primary mt-5"><c:out value="${dojo.name} Location Ninjas"></c:out></h1>
		<div class="text-center">
			<table class="table table-striped border border-dark border-3">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Age</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dojo" items="${dojo.ninjas}">
						<tr>
							<td><c:out value="${dojo.firstName}"/></td>
							<td><c:out value="${dojo.lastName}"/></td>
							<td><c:out value="${dojo.age}"/></td>
						</tr>
					</c:forEach>
				</tbody>			
			</table>
		</div>
		<a href="/dojos/new">Add Another Dojo</a><br>
		<a href="/ninjas/new">Add Another Ninja</a>
	</div>
</body>
</html>