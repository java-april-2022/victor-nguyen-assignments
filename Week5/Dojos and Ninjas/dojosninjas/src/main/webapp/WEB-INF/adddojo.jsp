<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojos</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="text-center mt-5">New Dojo</h1>
		<div class="w-auto d-flex justify-content-center">
			<form:form action="/dojos/new" method="post" modelAttribute="dojo">
				<div class="form-group p-4 d-block">
					<form:label path="name" class="form-label text-start">Name: </form:label><br>
					<form:errors path="name" class="text-danger"/>
					<form:input path="name" type="text" class="form-control"/>
				</div>
				<div class="d-flex justify-content-end">
					<input type="submit" value="Add Dojo" class="btn btn-primary me-5 mb-5"/>
				</div>
			</form:form>
		</div>
		<h2 class="text-center mt-5">Dojos:</h2>
		<div class="w-auto text-center">
			<c:forEach var="dojo" items="${allDojos}">
				<a href="/dojos/<c:out value="${dojo.id}"/>"><c:out value="${dojo.name}"/></a><br>
			</c:forEach>
		</div>
		<a href="/ninjas/new">Add a Ninja</a>
	</div>
</body>
</html>