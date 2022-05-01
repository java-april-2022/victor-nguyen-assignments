<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Expense</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-between align-items-center m-5">
			<h1 class="text-primary">Expense Details</h1>
			<a href="/expenses">Go back</a>
		</div>
		<div class="m-5 border border-dark border-3 p-5 w-50">
			<p class="d-flex justify-content-between w-75">
				<span class="fw-bold">Expense: </span>
				<span class="text-start w-50"> ${expense.name} </span>
			</p>
			<p class="d-flex justify-content-between w-75">
				<span class="fw-bold">Vendor:  </span>
				<span class="text-start w-50">${expense.vendor} </span>
			</p>
			<p class="d-flex justify-content-between w-75">
				<span class="fw-bold">Amount Spent: </span>
				<span class="text-start w-50">${expense.amount} </span>
			</p>
			<p class="d-flex justify-content-between w-75">
				<span class="fw-bold">Expense Description: </span>
				<span class="text-start w-50">${expense.description} </span>
			</p>
		</div>
	</div>
</body>
</html>