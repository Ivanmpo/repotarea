package com.everis.data.services;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Alumno;
import com.everis.data.repository.AlumnoRepository;

@Service
public class AlumnoService {

	
	@Autowired
	private AlumnoRepository ar;


	public List<Alumno> findAll() {
		return ar.findAll();
	}
	
	public Alumno crearAlumno(@Valid Alumno alumno) {
		return ar.save(alumno);
	}
	
	public Alumno findById(Long id) {
		return ar.getById(id);
	}
	
	public void modificarAlumno(@Valid Alumno alumno) {
		ar.save(alumno);
	}
	
	public void eliminarAlumno(Long id) {
		ar.deleteById(id);
	}
}
