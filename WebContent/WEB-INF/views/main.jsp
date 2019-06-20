<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@
taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"
 %>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Gestor de sucursales</title>
	<link href="resources/css/bootstrap.min.css" rel = "stylesheet">
	<link href="resources/css/styles.css" rel = "stylesheet">
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body class = "container maxHeight centerItems jumbotron">

	<h1>Gestor de sucursales</h1>
	<br>
	<form action="${pageContext.request.contextPath}/login" method="post">
		<div class="flexHor">
			<input type="text" name="username" id = "" class = "form-control InputField" placeholder="Username; ex. admin">
			<input type="password" name="password" id = "" class = "form-control InputField" placeholder="Password; ex. root">
		</div>
		
		<br>
		
		<div class="flexHor">
			<input type="submit" id = "searchBtn" name="Submit" value="Iniciar Sesión" class="btn btn-primary"/>
		</div>
	</form>	
	<br>
	<br>
	<c:if test="${not empty hasError}">
		<div class="alert alert-dismissible alert-danger">
		  <button type="button" class="close" data-dismiss="alert">&times;</button>
		  <p>${response}</p>
		</div>
	</c:if>
	
</body>
</html>