<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Expense</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div>
		<div class="d-flex justify-content-around mt-3 align-items-center">
			<h1 class="text-success">Edit Expense</h1>
			<a href="/expenses">Go back</a>
		</div>
		<div class="d-flex justify-content-center mt-3">
			<form:form action="/expenses/${expense.id}" method="post" modelAttribute="expense" class="text-center w-25 m-5 mt-3 border border-secondary border-3">
				<input type="hidden" name="_method" value="put">
				<div class="form-group p-4 d-block">
					<form:label path="name" class="form-label text-start">Expense: </form:label><br>
					<form:errors path="name" class="text-danger"/>
					<form:input path="name" type="text" class="form-control"/>
				</div>
				<br/>
				<div class="form-group p-4">
					<form:label path="vendor" class="form-label text-start">Vendor: </form:label><br>
					<form:errors path="vendor" class="text-danger"/>
					<form:input path="vendor" type="text" class="form-control"/>
				</div>
				<div class="form-group p-4">
					<form:label path="amount" class="form-label text-start">Amount: </form:label><br>
					<form:errors path="amount" class="text-danger"/>
					<form:input path="amount" type="double" class="form-control"/>
				</div>
				<div class="form-group p-4">
					<form:label path="description" class="form-label text-start">Description: </form:label><br>
					<form:errors path="description" class="text-danger"/>
					<form:textarea path="description" rows="3" columns="20" class="form-control"/>
				</div>
				<div class="d-flex justify-content-end">
					<input type="submit" value="Add Expense" class="btn btn-primary me-5 mb-5"/>
				</div>
			</form:form>
		</div>
	</div>	
	</div>	
</body>
</html>