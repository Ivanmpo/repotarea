<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Listado de Usuarios en el sistema</title>
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
	<h2>Listado de Cuentas</h2>
	<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#crearUsuarioModal">
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
	      <th scope="col">Usuario</th>
	      <th scope="col">Activo</th>
	      <th scope="col">Acción</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${lista_usuarios}" var="usuario">
				<tr>
					<td> <c:out value="${usuario.id}"/> </td>
					<td> <c:out value="${usuario.nombreUsuario}"></c:out> </td>
					<td> 
					<c:choose>
					    <c:when test="${usuario.activo==false}">
					        Desactivado
					        
					    </c:when>    
					    <c:otherwise>
					        Activado
					    </c:otherwise>
					</c:choose>
					</td>
					
					 <td>
					 	<a href="/admin/cuentas/modificar/${usuario.id}" class="btn btn-primary"><i class="fas fa-edit"></i></a>
					 	<a href="/admin/cuentas/eliminar/${usuario.id}" class="btn btn-danger"><i class="fas fa-trash-alt"></i></a>
					 	<a href="/admin/cuentas/consultar/${usuario.id}" class="btn btn-primary"><i class="bi bi-caret-right-fill"></i></a>
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
<div class="modal fade" id="crearUsuarioModal" tabindex="-1" aria-labelledby="crearUsuarioModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="crearUsuarioModalLabel">Crear usuario</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form:form action="/admin/cuentas/crear" method="POST" modelAttribute="cuenta">
			<div class="row g-3">
				<div class="col-md-6">
					<form:label path="nombreUsuario">Nombre de Usuario</form:label>
					<form:input type="text" id="nombreUsuario" path="nombreUsuario" class="form-control"/>
				</div>
				<div class="col-md-6">
					<form:label path="contrasena">Contraseña</form:label>
					<form:input type="text" id="contrasena" path="contrasena" class="form-control"/>
				</div>
				<!--<form:hidden path="tipoUsuario" value="2"/>-->
				<div class="col-md-12">
					<input type="submit" value="Crear Usuario"  class="btn btn-primary">
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