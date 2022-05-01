<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Travels</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="text-primary mt-5">Save Travels</h1>
		<div class="text-center">
			<table class="table table-striped border border-dark border-3">
				<thead>
					<tr>
						<th>Expense</th>
						<th>Vendor</th>
						<th>Amount</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="expense" items="${expenses}">
						<tr>
							<td><a href="/expenses/${expense.id}">${expense.name}</a></td>
							<td>${expense.vendor}</td>
							<td>$ ${expense.amount}</td>
							<td class="d-flex justify-content-center">
								<a href="/edit/${expense.id}" class="me-5">edit</a>
								|
								<form action="/expenses/${expense.id}" method="post" class="ms-5">
									<input type="hidden" name="_method" value="delete">
									<input type="submit" value="Delete" class="btn btn-danger">
								</form>
							</td>  
						</tr>
					</c:forEach>
				</tbody>			
			</table>
		</div>
		<div>
			<h2 class="text-primary mt-5">Add an expense: </h2>
			<div class="d-flex justify-content-center mt-3">
				<form:form action="/expenses" method="post" modelAttribute="expense" class="text-center w-50 m-5 mt-3 border border-secondary border-3">
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