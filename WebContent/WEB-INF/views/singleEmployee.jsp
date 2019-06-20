<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "f"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>${employee.name}</title>
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel = "stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel = "stylesheet">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body class = "container centerItems jumbotron">

	<button type="button" class="btn btn-info" style = "width: 75%" onclick="window.location.href = '${pageContext.request.contextPath}/Store?id=${employee.office.id}'">
		<i class="fas fa-backward"></i> ${employee.office.name}
	</button>

	<div class="jumbotron">
	  <h1 class="display-3">${employee.name}</h1>
	  <p class="lead">Edad: ${employee.age} años</p>
	  <hr class="my-4">
	  <p>Género: ${employee.genderDelegate}</p>
	  <p>Sucursal: ${employee.office.name}</p>
	  <p>Estado: ${employee.statusDelegate }</p>
	  <br>
	  <p class="lead">
	    <button type="button" class="btn btn-outline-primary btn-lg" style="margin:0 0 1rem 0" data-toggle="modal" data-target="#editEmployeeModal">
			<i class="fas fa-edit"></i> Editar registros básicos.
		</button>
	  </p>
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
	</div>
	
	<div class="modal fade" id = "editEmployeeModal"  tabindex="-1" role="dialog">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">Registro de empleado</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <f:form id="editEmployeeStoreForm"  action="${pageContext.request.contextPath}/editEmployee" class="centerItems" method="post" modelAttribute="employeeForm">
	        	<f:input type= "hidden" path="id"/>
	        	<label>Nombre del empleado</label>
	        	<f:input class="form-control" type="text" path="name" id="name"/>
	        	<br>
	        	<label>Edad</label>
	        	<f:input class="form-control" type="number" path="age"/>
	        	<br>
	        	<label>Genero:</label>
	        	<f:select class = "form-control" path="gender">
	        		<f:option value="M">Masculino</f:option>
	        		<f:option value="F">Femenino</f:option>
	        	</f:select>
	        	<br>
	        	<label>Cantidad de mesas</label>
	        	<f:select class = "form-control" path="status">
	        		<f:option value="false">Inactivo</f:option>
	        		<f:option value="true">Activo</f:option>
	        	</f:select>
	        	<br>
	        	
	        	<c:if test="${not empty hasErrorsForm}">
			       	<div class="alert alert-dismissible alert-danger">
					  <button type="button" class="close" data-dismiss="alert">&times;</button>
					  	<p><f:errors path="name"/></p>
					  	<p><f:errors path="age"/></p>
					  	<p><f:errors path="gender"/></p>
					  	<p><f:errors path="status"/></p>
					</div>
			     </c:if>
	        </f:form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" id="submit_store_employee" class="btn btn-primary">Editar Empleado</button>
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	
</body>
<script type="text/javascript">

	document.querySelector("#submit_store_employee").onclick = ()=>{

		document.querySelector("#editEmployeeStoreForm").submit()	
		}
	
</script>
</html>