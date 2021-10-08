<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Editar Usuario</title>
</head>
<body>
	<div class="container">
	
		<form:form action="/admin/cuentas/modificar/${usuario.id}" method="POST" modelAttribute="cuenta">
		<input type="hidden" name="_method" value="PUT">
		<form:hidden path="id"/>
		<div class="row g-3">
			<div class="col-md-6">
				<form:label path="nombreUsuario">Nombre de Usuario</form:label>
				<form:label path="nombreUsuario">
				<b> <c:out value="${cuenta.nombreUsuario}"></c:out></b>
				</form:label>
			</div>
			<div class="col-md-6">
				<label for="contrasena">Contraseña: </label>
				<form:label path="contrasena">
				<b> <c:out value="${cuenta.contrasena}"></c:out></b>
				</form:label>
			</div>
			<div class="col-md-6">
				<label for="activo">Estado de Cuenta</label>
				<form:label path="activo">
				<b> <c:out value="${cuenta.activo}"></c:out></b>
				</form:label>
			</div>
			<form:hidden path="tipoUsuario"/>
			<div class="col-md-12">
				<a href="/admin/cuentas/modificar/${cuenta.id}" class="btn btn-primary"><i class="fas fa-edit"></i></a>
				<a href="/admin/cuentas" class="btn btn-primary"><i
						class="bi bi-back"></i></a>
			</div>
		</div>
	</form:form>
		
	</div>
</body>
</html>