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
<title>Editar Alumno</title>
</head>
<body>
	<div class="container">
	
		<form:form action="/admin/alumno/actualizar" method="POST" modelAttribute="alumno">
			<input type="hidden" name="_method" value="PUT">
			<form:hidden path="id"/>
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
					<form:label  path="region">Región</form:label >
					<form:input type="text" id="region" path="region" class="form-control"/>
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
					<input type="submit" value="Actualizar alumno"  class="btn btn-primary">
				</div>
			</div>
		</form:form>
		
	</div>
</body>
</html>