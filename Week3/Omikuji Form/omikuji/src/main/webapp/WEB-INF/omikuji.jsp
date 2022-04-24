<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<h1 class="text-center">Send an Omikuji!</h1>
	<div class="d-flex justify-content-center">
	<form action="/omikujiform" method="POST" class="text-center w-25 m-5 mt-1 border border-secondary border-3 d-flex justify-content-start">
		<div class="m-5 w-100">
			<div class="d-flex justify-content-start mt-1">
				<label class="form-label text-start">
					Pick any number from 5 to 25.
					<input type="number" name="number" class="form-control w-25"/>
				</label>
			</div>
			<div class="d-flex justify-content-start mt-3">
				<label class="form-label text-start">
					Enter the name of any city.
					<input type="text" name="city" class="form-control"/>
				</label>
			</div>
			<div class="d-flex justify-content-start mt-3">
				<label class="form-label text-start">
					Enter the name of any real person.
					<input type="text" name="person" class="form-control"/>
				</label>
			</div>
			<div class="d-flex justify-content-start mt-3">
				<label class="form-label text-start">
					Enter professional endeavor or hobby.
					<input type="text" name="hobby" class="form-control"/>
				</label>
			</div>
			<div class="d-flex justify-content-start mt-3">
				<label class="form-label text-start">
					Enter any type of living thing.
					<input type="text" name="thing" class="form-control"/>
				</label>
			</div>
			<div class="d-flex justify-content-start mt-3">
				<label class="form-label text-start">
					Say something nice to someone:
					<textarea rows="10" cols="30" name="nicequote" class="form-control"></textarea>
				</label>
			</div>
			<div class="d-flex inline-block">
				<p class="me-5">Send and show a friend!</p>
				<input type="submit" value="Send" class="btn btn-primary mt-5 ms-5"/>
			</div>
		</div>
	</form>
	</div>
</body>
</html>