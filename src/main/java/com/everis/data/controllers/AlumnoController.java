package com.everis.data.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.everis.data.models.Alumno;
import com.everis.data.services.AlumnoService;

@RequestMapping("/admin")
@Controller
public class AlumnoController {

	@Autowired
	private AlumnoService as;

	 
	@RequestMapping("/")
	public String inicio(HttpSession session) {
		return "redirect:/admin/alumnos";
	}
	 
	
	@RequestMapping("/alumnos")
	public String alumnos(HttpSession session,@ModelAttribute("alumno") Alumno alumno, Model model) {
		model.addAttribute("lista_alumnos", as.findAll());
		return "listado_alumnos.jsp";

	}
	
	

	
	//Crear
	@RequestMapping(value="/alumno/crear", method =RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("usuario") Alumno alumno, RedirectAttributes attrs) {
		as.crearAlumno(alumno);
		attrs.addFlashAttribute("message", "Alumno Creado");
		return "redirect:/admin/alumnos";
	}
	
	//Actualizar y modificar
	
	@RequestMapping(value="/alumno/modificar/{id}", method = RequestMethod.GET)
	public String modificar(@PathVariable("id") Long id, Model model) {
		Alumno alumno = as.findById(id);
		model.addAttribute("alumno", alumno);
		return "editar_alumno.jsp";
	}
		
	@RequestMapping(value="/alumno/actualizar", method=RequestMethod.PUT)
	public String actualizar(@Valid @ModelAttribute("alumno") Alumno alumno, RedirectAttributes attrs) {
		as.modificarAlumno(alumno);
		attrs.addFlashAttribute("message", "Alumno Modificado");
		return "redirect:/admin/alumnos";
	}
	
	//Eliminar
	@RequestMapping(value="/alumno/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable("id") Long id, Model model, RedirectAttributes attrs) {
		as.eliminarAlumno(id);
		attrs.addFlashAttribute("message", "Alumno Eliminado");
		return "redirect:/admin/alumnos";
	}
	
}
