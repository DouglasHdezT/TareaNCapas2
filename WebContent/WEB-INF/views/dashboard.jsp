<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "f"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Dashboard</title>
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel = "stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel = "stylesheet">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body class = "container centerItems jumbotron">
	
	<h2>Bienvenidos</h2>
	<h4>Gestor de sucursales</h4>
	
	<br>
	
	<button type="button" class="btn btn-outline-primary btn-lg" style="margin:0 0 1rem 0" data-toggle="modal" data-target="#registerModal">
		<i class="fas fa-plus"></i> Registrar nueva sucursal
	</button>
	
	<div class="modal fade" id = "registerModal"  tabindex="-1" role="dialog">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">Registro de sucursal</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <f:form id="newStoreForm"  action="${pageContext.request.contextPath}/addStore" class="centerItems" method="post" modelAttribute="sucursal">
	        	<label>Nombre de la sucursal</label>
	        	<f:input class="form-control" type="text" path="name" id="name"/>
	        	<br>
	        	<label>Direccion</label>
	        	<f:input class="form-control" type="text" path="location"/>
	        	<br>
	        	<label>Horario:</label>
	        	<div class = "flexHor">
	        		<span>De:</span>
	        		<f:input class="form-control" type="time" path="openingSchedule"/>
	        		<span>A:</span>
	        		<f:input class="form-control" type="time" path="closingSchedule"/>
	        	</div>
	        	<br>
	        	<label>Cantidad de mesas</label>
	        	<f:input class="form-control" type="number" min="1" path="numSpaces"/>
	        	<br>
	        	<label>Nombre del gerente</label>
	        	<f:input class="form-control" type="text" path="managerName"/>
	        	<br>
	        	
	        	<c:if test="${not empty hasErrorsForm}">
			       	<div class="alert alert-dismissible alert-danger">
					  <button type="button" class="close" data-dismiss="alert">&times;</button>
					  	<p><f:errors path="name"/></p>
					  	<p><f:errors path="location"/></p>
					  	<p><f:errors path="openingSchedule"/></p>
					  	<p><f:errors path="closingSchedule"/></p>
					  	<p><f:errors path="numSpaces"/></p>
					  	<p><f:errors path="managerName"/></p>
					</div>
			     </c:if>
	        </f:form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" id="submit_store" class="btn btn-primary">Ingresar sucursal</button>
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	
      	
     <c:if test="${hasErrors == 'No'}">
     	<div class="alert alert-dismissible alert-success">
		  <button type="button" class="close" data-dismiss="alert">&times;</button>
		  <strong>${message}</strong>.
		</div>
     </c:if>
     <c:if test="${hasErrors == 'Yes'}">
     	<div class="alert alert-dismissible alert-danger">
		  <button type="button" class="close" data-dismiss="alert">&times;</button>
		  <strong>${message}</strong>.
		</div>
     </c:if>
	
	<div class="cards-containers">
	
		<c:forEach items="${sucursales}" var="sucursal">
		
			<div class="card text-white bg-primary mb-3 mr-3 ml-3" style="width: 20rem;">
			  <div class="card-header">Horario: ${sucursal.openingSchedule} - ${sucursal.closingSchedule}</div>
			  <div class="card-body">
			    <h4 class="card-title" style="height: 4rem;">${sucursal.name}</h4>
			    <p class="card-text" style="height: 4rem;">${sucursal.location}</p>
			    <div class="flexHor three-btn card-text">
			    	<button type="button" class="btn btn-secondary" onclick="window.location.href = '${pageContext.request.contextPath}/Store?id=${sucursal.id}'"><i class="fas fa-address-card"></i></button>
			    	<button type="button" class="btn btn-danger" onclick="window.location.href = '${pageContext.request.contextPath}/deleteStore?id=${sucursal.id}'">
			    		<i class="fas fa-trash"></i>
			    	</button>
			    </div>
			  </div>
			</div> 
			
		</c:forEach>
	
	</div>
</body>
<script type="text/javascript">

	document.querySelector("#submit_store").onclick = ()=>{

		document.querySelector("#newStoreForm").submit()	
		}
	
</script>
</html>