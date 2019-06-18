<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resultset</title>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel = "stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel = "stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
</head>
<body class = "container centerItems jumbotron">
	
	<h2>Bienvenidos</h2>
	<h3>Gestor de sucursales</h3>
	
	<br>
	
	<div class="cards-containers">
	
		<c:forEach items="${sucursales}" var="sucursal">
		
			<div class="card text-white bg-primary mb-3 mr-3 ml-3" style="width: 20rem;">
			  <div class="card-header">Horario: ${sucursal.openingSchedule} - ${sucursal.closingSchedule}</div>
			  <div class="card-body">
			    <h4 class="card-title" style="height: 4rem;">${sucursal.name}</h4>
			    <p class="card-text" style="height: 4rem;">${sucursal.location}</p>
			    <div class="flexHor three-btn card-text">
			    	<button type="button" class="btn btn-secondary"><i class="fas fa-address-card"></i></button>
			    	<button type="button" class="btn btn-info"><i class="fas fa-edit"></i></button>
			    	<button type="button" class="btn btn-danger"><i class="fas fa-trash"></i></button>
			    </div>
			  </div>
			</div> 
			
		</c:forEach>
	
	</div>
</body>
</html>