<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />


<title>Home - Gestión de Alumnos</title>
</head>
<body>

<nav class="nav py-3 text-center">
  <div class="container-fluid">

	<div class="row g-3">
		<div class="col-md-3">
			<i class="fas fa-user-circle"></i> <%= session.getAttribute("nombreUsuario") %> Ultimo acceso
		</div>
		<div class="col-md-3">
			<h2>Everis Academy</h2>
		</div>
		<div class="col-md-2">
       		<div class="row g-3">
			  <div class="col-auto">
			    <input class="form-control" type="search" placeholder="Buscar">
			  </div>
			  <div class="col-auto">
			    <button class="btn btn-outline-success" type="submit">Buscar</button>
			  </div>
			</div>
		</div>
		<div class="col-md-2">
			<i class="far fa-question-circle"></i> Ayuda
		</div>
		<div class="col-md-2">
			<a class="btn btn-primary" href="/logout" role="button">Cerrar Sesión</a>
		</div>
		
	</div>
  </div>
</nav>




<div class="container-fluid">
	<div class="row my-2">
		<nav aria-label="breadcrumb">
		  <ol class="breadcrumb">
		    <li class="breadcrumb-item active">Home</li>
		  </ol>
		</nav>
		
		
		<nav class="navbar navbar-expand-lg bg-light">
		  <div class="container-fluid">
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarNavDropdown">
		      <ul class="navbar-nav">
	
		        <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            Alumnos
		          </a>
		          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
		            <li><a class="dropdown-item" href="/admin/alumnos">Lista de Alumnos</a></li>
		            
		          </ul>
		        </li>
		        <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            Usuarios
		          </a>
		          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
		            <li><a class="dropdown-item" href="/admin/cuentas">Lista de Usuarios</a></li>
		            
		          </ul>
		        </li>
		        
		      </ul>
		    </div>
		  </div>
		</nav>
	</div>
	
	
	<div class="row">
		<div class="col">
			<div class="card">
			  <div class="card-body">
			  	<div class="row">
			  		<div class="col-md-3">
			  			<div id="chartContainer" style="height: 370px; width: 100%;"></div>
			  		</div>
			  		<div class="col-md-3">
			  			<div id="chartContainer2" style="height: 370px; width: 100%;"></div>
			  		</div>
			  	</div>
			  
			  
			    
			  </div>
			</div>
		</div>
	</div>
	
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-kQtW33rZJAHjgefvhyyzcGF3C5TFyBQBA13V1RKPf4uH+bwyzQxZ6CmMZHmNBEfJ" crossorigin="anonymous"></script>
<script>
	window.onload = function() {
	
	var chart = new CanvasJS.Chart("chartContainer", {
		animationEnabled: true,
		title: {
			text: "Q Alumnos"
		},
		data: [{
			type: "pie",
			startAngle: 240,
			yValueFormatString: "##0.00\"%\"",
			indexLabel: "{label} {y}",
			dataPoints: [
				{y: 50, label: "Masculino"},
				{y: 50, label: "Femenino"}
			]
		}]
	});
	chart.render();
	
	var chart2 = new CanvasJS.Chart("chartContainer2", {
		animationEnabled: true,
		title: {
			text: "Q Alumnos 2"
		},
		data: [{
			type: "pie",
			startAngle: 240,
			yValueFormatString: "##0.00\"%\"",
			indexLabel: "{label} {y}",
			dataPoints: [
				{y: 50, label: "Masculino"},
				{y: 50, label: "Femenino"}
			]
		}]
	});
	chart2.render();
	
	
	}
</script>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>