<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Ninja</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="text-center mt-5">New Ninja</h1>
		<div class="w-auto d-flex justify-content-center">
			<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
				<div class="form-group p-4 d-block">
					<form:label path="firstName" class="form-label text-start">First Name: </form:label><br>
					<form:errors path="firstName" class="text-danger"/>
					<form:input path="firstName" type="text" class="form-control"/>
				</div>
				<div class="form-group p-4 d-block">
					<form:label path="lastName" class="form-label text-start">Last Name: </form:label><br>
					<form:errors path="lastName" class="text-danger"/>
					<form:input path="lastName" type="text" class="form-control"/>
				</div>
				<div class="form-group p-4 d-block">
					<form:label path="age" class="form-label text-start">Age: </form:label><br>
					<form:errors path="age" class="text-danger"/>
					<form:input path="age" type="number" class="form-control"/>
				</div>
				<div class="form-group p-4 d-block">
					<form:label path="dojo" class="form-label text-start">Dojo: </form:label><br>
					<form:select path="dojo">Dojo: 
						<c:forEach var="dojo" items="${allDojos}">
							<option value="${dojo.id}"><c:out value="${dojo.name}"/></option>
						</c:forEach>				
					</form:select>
				</div>
				<div class="d-flex justify-content-end">
					<input type="submit" value="Add Ninja" class="btn btn-primary me-5 mb-5"/>
				</div>
			</form:form>
		</div>
		<a href="/dojos/new">Add a Dojo</a>
	</div>
</body>
</html>