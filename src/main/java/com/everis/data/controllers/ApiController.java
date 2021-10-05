package com.everis.data.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.data.models.Alumno;
import com.everis.data.services.AlumnoService;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private AlumnoService as;
	
	@GetMapping("/alumnos")
	public List<Alumno> obtenerUsuarios(){
		return as.findAll();
	}
	
	
}
