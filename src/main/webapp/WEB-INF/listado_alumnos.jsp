<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Listado de Alumnos en el sistema</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg bg-light">
		<div class="container-fluid">
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
				aria-controls="navbarNavDropdown" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<ul class="navbar-nav">
					<li class="nav-item">
			        	<a class="nav-link " aria-current="page" href="/admin/home">Home</a>
			        </li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Alumnos </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
							<li><a class="dropdown-item" href="/admin/alumnos">Lista
									de Alumnos</a></li>

						</ul></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Usuarios </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
							<li><a class="dropdown-item" href="/admin/cuentas">Lista
									de Usuarios</a></li>

						</ul></li>

				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
	<h2>Listado de Alumnos</h2>
	<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#crearAlumnoModal">
	  Crear Usuario
	</button>
	<c:if test="${mensajes!=null}">
		<div class="alert alert-primary" role="alert">
			<c:forEach items="${mensajes}" var="mensaje">
				<p>${mensaje }</p>
			</c:forEach>
		</div>
	</c:if>
	<table class="table table-bordered">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Nombre</th>
	      <th scope="col">Rut</th>
	      <th scope="col">Ciudad</th>
	      <th scope="col">Acción</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${lista_alumnos}" var="alumno">
				<tr>
					<td> <c:out value="${alumno.id}"/> </td>
					<td> <c:out value="${alumno.nombre}"></c:out> </td>
					<td> <c:out value="${alumno.rut}"></c:out> </td>
					<td> <c:out value="${alumno.ciudad}"></c:out> </td>

					 <td> 
					 	
					 	<a href="/admin/alumno/modificar/${alumno.id}" class="btn btn-primary"><i class="fas fa-edit"></i></a>
					 	<a href="/admin/alumno/eliminar/${alumno.id}" class="btn btn-danger"><i class="fas fa-trash-alt"></i></a>
					 	
						<!--<form action="/alumno/eliminar" method="POST">
							<input type="hidden" name="id" value="<c:out value="${alumno.id}" />">
							<input type="submit" value="Eliminar" class="btn btn-primary">
						</form>
						-->
					</td>
				</tr>
			</c:forEach>
			

	  </tbody>
	</table>

</div>
	

<!-- Modal -->
<div class="modal fade" id="crearAlumnoModal" tabindex="-1" aria-labelledby="crearAlumnoModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="crearAlumnoModalLabel">Crear Alumno</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form:form action="/admin/alumno/crear" method="POST" modelAttribute="alumno">
			<div class="row g-3">
				<div class="col-md-6">
					<form:label path="nombre">Primer Nombre</form:label>
					<form:input type="text" id="nombre" path="nombre" class="form-control"/>
				</div>
				<div class="col-md-6">
					<form:label path="segundo_nombre">Segundo Nombre:</form:label>
					<form:input type="text" id="segundo_nombre" path="segundo_nombre" class="form-control"/>
				</div>
				<div class="col-md-6">
					<form:label path="apellido_paterno">Apellido Paterno</form:label>
					<form:input type="text" id="apellido_paterno" path="apellido_paterno" class="form-control"/>
				</div>
				<div class="col-md-6">
					<form:label path="apellido_materno">Apellido Paterno</form:label>
					<form:input type="text" id="apellido_materno" path="apellido_materno" class="form-control"/>
				</div>
				<div class="col-md-6">
					<form:label  path="rut">Rut</form:label >
					<form:input type="text" id="rut" path="rut" class="form-control"/>
				</div>
				<div class="col-md-12">
					<form:label  path="direccion">Dirección</form:label >
					<form:input type="text" id="direccion" path="direccion" class="form-control"/>
				</div>
				<div class="col-md-6">
					<form:label  path="ciudad">Ciudad</form:label >
					<form:input type="text" id="ciudad" path="ciudad" class="form-control"/>
				</div>
				<div class="col-md-6">
					<label for="region">Región</label>
					<form:select path="region"  class="form-control">
						<form:option value="" selected="selected" label="Seleccionar una región" />
						<form:option value="Tarapaca" label="1 Tarapaca" />
						<form:option value="Antofagasta" label="2 Antofagasta" />
						<form:option value="Atacama" label="3 Atacama" />
						<form:option value="Coquimbo" label="4 Coquimbo" />
						<form:option value="Valparaiso" label="5 Valparaiso" />
						<form:option value="OHiggins" label="6 O'Higgins" />
						<form:option value="Maule" label="7 Maule" />
						<form:option value="Bio Bio" label="8 Bio - Bio" />
						<form:option value="Araucania" label="9 Araucania" />
						<form:option value="Los Lagos" label="10 Los Lagos" />
						<form:option value="Aisen" label="11 Aisen" />
						<form:option value="Magallanes Y Antartica"  label="12 Magallanes Y Antartica" />
						<form:option value="Metropolitana" label="13 Metropolitana" />
						<form:option value="Los Rios" label="14 Los Rios" />
						<form:option value="Arica y Parinacota" label="15 Arica y Parinacota" />
					</form:select>
				</div>
				<div class="col-md-6">
					<form:label  path="correo">Correo</form:label >
					<form:input type="text" id="correo" path="correo" class="form-control"/>
				</div>
				<div class="col-md-6">
					<form:label  path="telefono">Teléfono</form:label >
					<form:input type="text" id="telefono" path="telefono" class="form-control"/>
				</div>
				<div class="col-md-12">
					<input type="submit" value="Crear alumno"  class="btn btn-primary">
				</div>
			</div>
		</form:form>
      </div>
      <div class="modal-footer">

	
      </div>
      
      
    </div>
  </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-kQtW33rZJAHjgefvhyyzcGF3C5TFyBQBA13V1RKPf4uH+bwyzQxZ6CmMZHmNBEfJ" crossorigin="anonymous"></script>
</body>
</html>