<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Editar Usuario</title>
</head>
<body>
	<div class="container">
	
		<form:form action="/admin/cuentas/actualizar" method="POST" modelAttribute="cuenta">
		<input type="hidden" name="_method" value="PUT">
		<form:hidden path="id"/>
		<div class="row g-3">
			<div class="col-md-6">
				<form:label path="nombreUsuario">Nombre de Usuario</form:label>
				<form:input type="text" id="nombreUsuario" path="nombreUsuario" class="form-control"/>
			</div>
			<div class="col-md-6">
				<label for="contrasena">Nueva Contraseña</label>
				<input type="text" id="contrasena" name="contrasena" class="form-control"/>
			</div>
			<div class="col-md-6">
				<form:select path="activo" items="${activoList}" class="form-select" />
			</div>
			<form:hidden path="tipoUsuario"/>
			<div class="col-md-12">
				<input type="submit" value="Actualizar Usuario"  class="btn btn-primary">
			</div>
		</div>
	</form:form>
		
	</div>
</body>
</html>