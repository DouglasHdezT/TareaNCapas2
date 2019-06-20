<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "f"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>${store.name}</title>
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel = "stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel = "stylesheet">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body class = "container centerItems jumbotron">

	<div class="jumbotron">
	  <h1 class="display-3">${store.name}</h1>
	  <p class="lead">Gerente: ${store.managerName}</p>
	  <hr class="my-4">
	  <p>Direcci�n: ${store.location}</p>
	  <p>Horario: ${store.openingSchedule} - ${store.closingSchedule}</p>
	  <p>${store.numSpaces} mesas</p>
	  <br>
	  <p class="lead">
	    <button type="button" class="btn btn-outline-primary btn-lg" style="margin:0 0 1rem 0" data-toggle="modal" data-target="#registerModal">
			<i class="fas fa-edit"></i> Editar registros b�sicos.
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
	        <f:form id="editStoreForm"  action="${pageContext.request.contextPath}/editStore" class="centerItems" method="post" modelAttribute="storeForm">
	        	<f:input type= "hidden" path="id"/>
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
	        <button type="button" id="submit_store" class="btn btn-primary">Editar sucursal</button>
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
	
     <h2>Empleados.</h2><br>
     <button type="button" class="btn btn-outline-primary btn-lg" style="margin:0 0 1rem 0" data-toggle="modal" data-target="#registerEmployeeModal">
		<i class="fas fa-plus"></i> A�adir empleado.
	</button><br>
	
	<div class="modal fade" id = "registerEmployeeModal"  tabindex="-1" role="dialog">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">Registro de empleado</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <f:form id="addEmployeeStoreForm"  action="${pageContext.request.contextPath}/addEmployee" class="centerItems" method="post" modelAttribute="employee">
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
	        	<input type="hidden" name = "id_store" value  = "${store.id}"/>
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
	        <button type="button" id="submit_store_employee" class="btn btn-primary">A�adir Empleado</button>
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr class="table-info">
		      <th scope="col">Nombre</th>
		      <th scope="col">Edad</th>
		      <th scope="col">G�nero</th>
		      <th scope="col">Status</th>
		      <th scope="col">Modificar</th>
		      <th scope="col">Eliminar</th>
		    </tr>
		</thead>
		<tbody>
			<c:forEach items="${empleados}" var="empl">
			
				<tr class="">
				
					<td>${empl.name}</td>
					<td >${empl.age}</td>
					<td>${empl.genderDelegate}</td>
					<td>${empl.statusDelegate}</td>
					<td ><button type="button" class="btn btn-secondary" onclick="window.location.href = '${pageContext.request.contextPath}/Employee?id=${empl.id}'"><i class="fas fa-address-card"></i></button></td>
					<td ><button type="button" class="btn btn-secondary" onclick="window.location.href = '${pageContext.request.contextPath}/deleteEmployee?id_store=${store.id}&id_employee=${empl.id}'"><i class="fas fa-trash"></i></button></td>
				
				</tr>
			
			</c:forEach>
		</tbody>
	</table>

</body>
<script type="text/javascript">

	document.querySelector("#submit_store").onclick = ()=>{

		document.querySelector("#editStoreForm").submit()	
		}

	document.querySelector("#submit_store_employee").onclick = ()=>{

		document.querySelector("#addEmployeeStoreForm").submit()	
		}
	
</script>
</html>