<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your fortune</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

	<h1 class="text-center m-4"> Here's your Omikuji!</h1>
	<div class="d-flex justify-content-center">	
		<div class="border border-secondary border-3 w-25 p-5 bg-info">
			<p>
				<c:out value="${fortune}"/>
			</p>
		</div>
	</div>
	<a href="/omikuji" class="d-flex justify-content-center mt-5">Go Back</a>	

</body>
</html>