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
	
	<p>${response}</p>
	
</body>
</html>