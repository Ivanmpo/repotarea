<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<title>Iniciar Sesión</title>
</head>
<body>

	<div class="container">

		<div class="row justify-content-md-center">
		<h1>Bienvenido/a a Everis Academy</h1>
			<div class="col col-md-6">
				<div class="card">
				
  					<div class="card-body">
	  					<div class="row justify-content-md-center">
	  						<div class="col col-md-6">
								<form action="/ingresar" method="post">
									<div class="mb-3">
										<label for="usuario">Usuario</label>
										<input type="text" id="usuario" name="usuario" placeholder="Nombre de Usuario" class="form-control"/>
									</div>
									<div class="mb-3">
										<label for="password">Password:</label>
										<input type="password" id="password" name="password" placeholder="Contraseña" class="form-control"/> 
									</div>
									<div class="mb-3">
										<button type="submit" class="btn btn-primary">Ingresar</button>
									</div>
									<a href="#">Recuperar clave</a>
								</form>
							</div>
						</div>
					</div>
				</div>
				
				
				
				
			</div>
			

		</div>


		<c:if test="${not empty mensaje}">
			<div class="alert alert-primary" role="alert">
				<c:out value="${mensaje}"/>
			</div>
		</c:if>
		
	</div>
</body>
</html>