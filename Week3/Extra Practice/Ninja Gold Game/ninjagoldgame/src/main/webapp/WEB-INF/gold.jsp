<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold Game</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

	<h1>Your Gold: <c:out value="${gold}" /></h1>

	<div class="d-flex justify-content-evenly m-5 p-5">
		<div class="border border-secondary border-3 p-5 m-5">
			<form action="/gold" method="post">
				<h2>Farm</h2>
				<p>(earns 10-20 gold)</p>
				<input type="submit" value="Find Gold!" name="farm" class="button"/>
			</form>
		</div>
		<div class="border border-secondary border-3 p-5 m-5">
			<form action="/gold" method="post">
				<h2>Cave</h2>
				<p>(earns 5-10 gold)</p>
				<input type="submit" value="Find Gold!" name="cave" class="button"/>
			</form>
		</div>
		<div class="border border-secondary border-3 p-5 m-5">
			<form action="/gold" method="post">
				<h2>House</h2>
				<p>(earns 2-5 gold)</p>
				<input type="submit" value="Find Gold!" name="house" class="button"/>
			</form>
		</div>
		<div class="border border-secondary border-3 p-5 m-5">
			<form action="/gold" method="post">
				<h2>Quest!</h2>
				<p>(earns/takes 50 gold)</p>
				<input type="submit" value="Find Gold!" name="quest" class="button"/>
			</form>
		</div>
		<div class="border border-secondary border-3 p-5 m-5">
			<form action="/gold" method="post">
				<h2>Spa</h2>
				<p>Rest and lose 2 gold per minute spent (10-40 minutes/5-20 gold)</p>
				<input type="submit" value="Find Gold!" name="spa" class="button"/>
			</form>
		</div>
	</div>

<br>
<h2>Activities</h2>
<br>
<iframe src="/activities/" title="Activities Iframe" class="border border-secondary border-3 w-50 m-5 mt-0"></iframe>
</body>
</html>