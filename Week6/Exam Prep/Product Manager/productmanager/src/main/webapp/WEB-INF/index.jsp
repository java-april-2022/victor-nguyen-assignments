<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Manager</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="mt-3 text-center text-primary">Project Manager</h1>
		<p class="text-center">A place for teams to manage projects.</p>
		<div class="d-flex justify-content-around">
			<div>
				<form:form action="/register" method="post" modelAttribute="newUser">
					<div class="mt-3 p-5 border border-secondary border-3">
						<h3 class="text-center">Register</h3>
						<hr>
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
							<form:label path="email" class="form-label text-start">Email: </form:label><br>
							<form:errors path="email" class="text-danger"/>
							<form:input path="email" type="text" class="form-control"/>
						</div>
						<div class="form-group p-4 d-block">
							<form:label path="password" class="form-label text-start">Password: </form:label><br>
							<form:errors path="password" class="text-danger"/>
							<form:input path="password" type="text" class="form-control"/>
						</div>
						<div class="form-group p-4 d-block">
							<form:label path="confirm" class="form-label text-start">Confirm Password: </form:label><br>
							<form:errors path="confirm" class="text-danger"/>
							<form:input path="confirm" type="text" class="form-control"/>
						</div>
						<input type="submit" value="Submit" class="btn btn-primary w-100"/>
					</div>
				</form:form>
			</div>
			<div>
				<form:form action="/login" method="post" modelAttribute="newLogin">
					<div class="mt-3 p-5 border border-secondary border-3">
						<h3 class="text-center">Login</h3>
						<hr>
						<div class="form-group p-4 d-block">
							<form:label path="email" class="form-label text-start">Email: </form:label><br>
							<form:errors path="email" class="text-danger"/>
							<form:input path="email" type="text" class="form-control"/>
						</div>
						<div class="form-group p-4 d-block">
							<form:label path="password" class="form-label text-start">Password: </form:label><br>
							<form:errors path="password" class="text-danger"/>
							<form:input path="password" type="text" class="form-control"/>
						</div>
						<input type="submit" value="Submit" class="btn btn-primary w-100"/>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>