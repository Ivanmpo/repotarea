<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
	integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Editar Alumno</title>
</head>
<body>
	<div class="container">

		<form:form action="/admin/alumno/modificar/${alumno.id}" method="POST"
			modelAttribute="alumno">
			<input type="hidden" name="_method" value="PUT">
			<form:hidden path="id" />
			<div class="row g-3">
				<div class="col-md-6">
					<!-- type="text" id="nombre" -->
					<form:label path="nombre">Primer Nombre:</form:label>
					<form:label path="nombre">
						<b> <c:out value="${alumno.nombre}"></c:out></b>
					</form:label>
				</div>
				<div class="col-md-6">
					<form:label path="segundo_nombre">Segundo Nombre:</form:label>
					<form:label path="segundo_nombre">
						<b><c:out value="${alumno.segundo_nombre}"></c:out></b>
					</form:label>
				</div>
				<div class="col-md-6">
					<form:label path="apellido_paterno">Apellido Paterno</form:label>
					<form:label path="apellido_paterno">
						<b><c:out value="${alumno.apellido_paterno}"></c:out></b>
					</form:label>
				</div>
				<div class="col-md-6">
					<form:label path="apellido_materno">Apellido Materno</form:label>
					<form:label path="apellido_materno">
						<b><c:out value="${alumno.apellido_materno}"></c:out></b>
					</form:label>
				</div>
				<div class="col-md-6">
					<form:label path="rut">Rut</form:label>
					<form:label path="rut">
						<b><c:out value="${alumno.rut}"></c:out></b>
					</form:label>
				</div>
				<div class="col-md-12">
					<form:label path="direccion">Dirección</form:label>
					<form:label path="direccion">
						<b><c:out value="${alumno.direccion}"></c:out></b>
					</form:label>
				</div>
				<div class="col-md-6">
					<form:label path="ciudad">Ciudad</form:label>
					<form:label path="ciudad">
						<b><c:out value="${alumno.ciudad}"></c:out></b>
					</form:label>
				</div>
				<div class="col-md-6">
					<form:label path="region">Región</form:label>
					<form:label path="region">
						<b><c:out value="${alumno.region}"></c:out></b>
					</form:label>
				</div>
				<div class="col-md-6">
					<form:label path="correo">Correo</form:label>
					<form:label path="correo">
						<b><c:out value="${alumno.correo}"></c:out></b>
					</form:label>
				</div>
				<div class="col-md-6">
					<form:label path="telefono">Teléfono</form:label>
					<form:label path="telefono">
						<b><c:out value="${alumno.telefono}"></c:out></b>
					</form:label>
				</div>
				<div class="col-md-12">
					<a href="/admin/alumno/modificar/${alumno.id}"
						class="btn btn-primary"><i class="fas fa-edit"></i></a> 
						<a href="/admin/alumnos" class="btn btn-primary"><i
						class="bi bi-back"></i></a>
					 



				</div>
			</div>
		</form:form>

	</div>
</body>
</html>