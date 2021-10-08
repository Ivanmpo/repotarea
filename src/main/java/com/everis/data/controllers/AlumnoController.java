package com.everis.data.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		boolean valid = true;
		List<String> mensajes = new ArrayList<String>();
		
		alumno.setNombre(alumno.getNombre().trim()); //Eliminamos posibles espacios en blanco
		if(!alumno.getNombre().isBlank()) {
			System.out.println(alumno.getNombre().length());
			if(alumno.getNombre().length()>1 && alumno.getNombre().length()<15) {
				if(!alumno.getNombre().matches(".*\\d.*")) {
					mensajes.add("Nombre Ok");
				}else {
					// contiene numeros
					mensajes.add("El nombre no puede contener números");
					valid =false;
				}
			}else {
				// fuera del rango
				mensajes.add("Nombre no puede estar fuera del rango");
				valid =false;
			}
		}else {
			// en blanco
			mensajes.add("El nombre no puede ir en blanco");
			valid =false;
		}
		
		alumno.setSegundo_nombre(alumno.getSegundo_nombre().trim()); //Eliminamos posibles espacios en blanco
		if(!alumno.getSegundo_nombre().isBlank()) {
			System.out.println(alumno.getSegundo_nombre().length());
			if(alumno.getSegundo_nombre().length()>1 && alumno.getSegundo_nombre().length()<15) {
				if(!alumno.getSegundo_nombre().matches(".*\\d.*")) {
					mensajes.add("Segundo nombre ok");
				}else {
					// contiene numeros
					mensajes.add("El segundo nombre no puede contener números");
					valid =false;
				}
			}else {
				// fuera del rango
				mensajes.add("Segundo Nombre no puede estar fuera del rango");
				valid =false;
			}
		}else {
			// en blanco
			mensajes.add("El segundo nombre no puede ir en blanco");
			valid =false;
		}
		
		alumno.setApellido_paterno(alumno.getApellido_paterno().trim()); //Eliminamos posibles espacios en blanco
		if(!alumno.getApellido_paterno().isBlank()) {
			System.out.println(alumno.getApellido_paterno().length());
			if(alumno.getApellido_paterno().length()>1 && alumno.getApellido_paterno().length()<15) {
				if(!alumno.getApellido_paterno().matches(".*\\d.*")) {
					mensajes.add("Apellido Paterno ok");
				}else {
					// contiene numeros
					mensajes.add("El Apellido Paterno no puede contener números");
					valid =false;
				}
			}else {
				// fuera del rango
				mensajes.add("Apellido Paterno no puede estar fuera del rango");
				valid =false;
			}
		}else {
			// en blanco
			mensajes.add("El Apellido Paterno no puede ir en blanco");
			valid =false;
		}
		
		alumno.setApellido_materno(alumno.getApellido_materno().trim()); //Eliminamos posibles espacios en blanco
		if(!alumno.getApellido_materno().isBlank()) {
			if(alumno.getApellido_materno().length()>1 && alumno.getApellido_materno().length()<15) {
				if(!alumno.getApellido_materno().matches(".*\\d.*")) {
					mensajes.add("Apellido Materno ok");
				}else {
					// contiene numeros
					mensajes.add("El Apellido Materno no puede contener números");
					valid =false;
				}
			}else {
				// fuera del rango
				mensajes.add("Apellido Materno no puede estar fuera del rango");
				valid =false;
			}
		}else {
			// en blanco
			mensajes.add("El Apellido Materno no puede ir en blanco");
			valid =false;
		}
		
		alumno.setRut(alumno.getRut().trim()); //Eliminamos posibles espacios en blanco
		if(!alumno.getRut().isBlank()) {
			if(alumno.getRut().length()>0 && alumno.getRut().length()<13) {
				if(this.validarRut(alumno.getRut())) {
					mensajes.add("RUT ok");
				}else {
					mensajes.add("El rut no es válido");
					valid =false;
				}
			}else {
				mensajes.add("El RUT ingresado esta fuera del rango");
				valid =false;
			}
		}else {
			mensajes.add("El RUT no puede ir en blanco");
			valid =false;
		}
		
		alumno.setDireccion(alumno.getDireccion().trim()); //Eliminamos posibles espacios en blanco
		if(!alumno.getDireccion().isBlank()) {
			if(alumno.getDireccion().length()>4 && alumno.getDireccion().length()<81) {
				mensajes.add("Dirección Ok");
			}else {
				mensajes.add("Dirección no puede estar fuera del rango (Hasta 80 caracteres)");
				valid =false;
			}
		}else {
			mensajes.add("La dirección no puede ir en blanco");
			valid =false;
		}
		

		alumno.setCiudad(alumno.getCiudad().trim()); //Eliminamos posibles espacios en blanco
		if(!alumno.getCiudad().isBlank()) {
			if(alumno.getCiudad().length()>0 && alumno.getCiudad().length()<31) {
				if(!alumno.getCiudad().matches(".*\\d.*")) {
					mensajes.add("Ciudad ok");
				}else {
					// contiene numeros
					mensajes.add("La ciudad no puede contener números");
					valid =false;
				}
			}else {
				// fuera del rango
				mensajes.add("Ciudad no puede estar fuera del rango (Hasta 30 caracteres)");
				valid =false;
			}
		}else {
			// en blanco
			mensajes.add("Ciudad no puede ir en blanco");
			valid =false;
		}
		
		
		alumno.setTelefono(alumno.getTelefono().trim()); //Eliminamos posibles espacios en blanco
		if(!alumno.getTelefono().isBlank()) {
			if(alumno.getTelefono().length()>0 && alumno.getTelefono().length()<12) {
				if(this.isNumeric(alumno.getTelefono())) {
					mensajes.add("Teléfono ok");
				}else {
					mensajes.add("El Teléfono no es váido. Debe ser sólo numerico de la forma 9 1111 2222 o 911112222");
					valid =false;
				}
			}else {
				mensajes.add("El Teléfono ingresado esta fuera del rango");
				valid =false;
			}
		}else {
			mensajes.add("El Teléfono no puede ir en blanco");
			valid =false;
		}
		
		
		alumno.setCorreo(alumno.getCorreo().trim()); //Eliminamos posibles espacios en blanco
		if(!alumno.getCorreo().isBlank()) {
			if(alumno.getCorreo().length()>0 && alumno.getCorreo().length()<51) {
				if(this.validaEmail(alumno.getCorreo())) {
					mensajes.add("Correo ok");
				}else {
					mensajes.add("El Correo es inválido. Escriba de la forma nombre@dominio.dom");
					valid =false;
				}
			}else {
				mensajes.add("El Correo ingresado esta fuera del rango (Hasta 50 caracteres)");
				valid =false;
			}
		}else {
			mensajes.add("El Correo no puede ir en blanco");
			valid =false;
		}
		
		
		
		if(alumno.getRegion().isBlank()) {
			mensajes.add("No seleccionó una región");
			valid =false;
		}else {
			mensajes.add("Región ok");
		}
		
		
		attrs.addFlashAttribute("mensajes", mensajes);
		if(valid) {
			as.crearAlumno(alumno);
			mensajes.add("Alumno Creado");	
		}else {
			mensajes.add("Problemas al crear alumno");
		}
		return "redirect:/admin/alumnos";
		
		//as.crearAlumno(alumno);
		//attrs.addFlashAttribute("message", "Alumno Creado");
		
	}
	
	//Actualizar y modificar
	
	@RequestMapping(value="/alumno/modificar/{id}", method = RequestMethod.GET)
	public String modificar(@PathVariable("id") Long id, Model model) {
		Alumno alumno = as.findById(id);
		model.addAttribute("alumno", alumno);
		return "editar_alumno.jsp";
	}
	
	@RequestMapping(value="/alumno/consultar/{id}", method = RequestMethod.GET)
		public String consultar(@PathVariable("id") Long id, Model model) {
		Alumno alumno = as.findById(id);
		model.addAttribute("alumno", alumno);
		return "consultar_alumno.jsp";
	}
	
		
	@RequestMapping(value="/alumno/actualizar", method=RequestMethod.PUT)
	public String actualizar(@Valid @ModelAttribute("alumno") Alumno alumno, RedirectAttributes attrs) {
		
		boolean valid = true;
		List<String> mensajes = new ArrayList<String>();
		
		alumno.setNombre(alumno.getNombre().trim()); //Eliminamos posibles espacios en blanco
		if(!alumno.getNombre().isBlank()) {
			System.out.println(alumno.getNombre().length());
			if(alumno.getNombre().length()>1 && alumno.getNombre().length()<15) {
				if(!alumno.getNombre().matches(".*\\d.*")) {
					mensajes.add("Nombre Ok");
				}else {
					// contiene numeros
					mensajes.add("El nombre no puede contener números");
					valid =false;
				}
			}else {
				// fuera del rango
				mensajes.add("Nombre no puede estar fuera del rango");
				valid =false;
			}
		}else {
			// en blanco
			mensajes.add("El nombre no puede ir en blanco");
			valid =false;
		}
		
		alumno.setSegundo_nombre(alumno.getSegundo_nombre().trim()); //Eliminamos posibles espacios en blanco
		if(!alumno.getSegundo_nombre().isBlank()) {
			System.out.println(alumno.getSegundo_nombre().length());
			if(alumno.getSegundo_nombre().length()>1 && alumno.getSegundo_nombre().length()<15) {
				if(!alumno.getSegundo_nombre().matches(".*\\d.*")) {
					mensajes.add("Segundo nombre ok");
				}else {
					// contiene numeros
					mensajes.add("El segundo nombre no puede contener números");
					valid =false;
				}
			}else {
				// fuera del rango
				mensajes.add("Segundo Nombre no puede estar fuera del rango");
				valid =false;
			}
		}else {
			// en blanco
			mensajes.add("El segundo nombre no puede ir en blanco");
			valid =false;
		}
		
		alumno.setApellido_paterno(alumno.getApellido_paterno().trim()); //Eliminamos posibles espacios en blanco
		if(!alumno.getApellido_paterno().isBlank()) {
			System.out.println(alumno.getApellido_paterno().length());
			if(alumno.getApellido_paterno().length()>1 && alumno.getApellido_paterno().length()<15) {
				if(!alumno.getApellido_paterno().matches(".*\\d.*")) {
					mensajes.add("Apellido Paterno ok");
				}else {
					// contiene numeros
					mensajes.add("El Apellido Paterno no puede contener números");
					valid =false;
				}
			}else {
				// fuera del rango
				mensajes.add("Apellido Paterno no puede estar fuera del rango");
				valid =false;
			}
		}else {
			// en blanco
			mensajes.add("El Apellido Paterno no puede ir en blanco");
			valid =false;
		}
		
		alumno.setApellido_materno(alumno.getApellido_materno().trim()); //Eliminamos posibles espacios en blanco
		if(!alumno.getApellido_materno().isBlank()) {
			if(alumno.getApellido_materno().length()>1 && alumno.getApellido_materno().length()<15) {
				if(!alumno.getApellido_materno().matches(".*\\d.*")) {
					mensajes.add("Apellido Materno ok");
				}else {
					// contiene numeros
					mensajes.add("El Apellido Materno no puede contener números");
					valid =false;
				}
			}else {
				// fuera del rango
				mensajes.add("Apellido Materno no puede estar fuera del rango");
				valid =false;
			}
		}else {
			// en blanco
			mensajes.add("El Apellido Materno no puede ir en blanco");
			valid =false;
		}
		
		alumno.setRut(alumno.getRut().trim()); //Eliminamos posibles espacios en blanco
		if(!alumno.getRut().isBlank()) {
			if(alumno.getRut().length()>0 && alumno.getRut().length()<13) {
				if(this.validarRut(alumno.getRut())) {
					mensajes.add("RUT ok");
				}else {
					mensajes.add("El rut no es válido");
					valid =false;
				}
			}else {
				mensajes.add("El RUT ingresado esta fuera del rango");
				valid =false;
			}
		}else {
			mensajes.add("El RUT no puede ir en blanco");
			valid =false;
		}
		
		alumno.setDireccion(alumno.getDireccion().trim()); //Eliminamos posibles espacios en blanco
		if(!alumno.getDireccion().isBlank()) {
			if(alumno.getDireccion().length()>4 && alumno.getDireccion().length()<81) {
				mensajes.add("Dirección Ok");
			}else {
				mensajes.add("Dirección no puede estar fuera del rango (Hasta 80 caracteres)");
				valid =false;
			}
		}else {
			mensajes.add("La dirección no puede ir en blanco");
			valid =false;
		}
		

		alumno.setCiudad(alumno.getCiudad().trim()); //Eliminamos posibles espacios en blanco
		if(!alumno.getCiudad().isBlank()) {
			if(alumno.getCiudad().length()>0 && alumno.getCiudad().length()<31) {
				if(!alumno.getCiudad().matches(".*\\d.*")) {
					mensajes.add("Ciudad ok");
				}else {
					// contiene numeros
					mensajes.add("La ciudad no puede contener números");
					valid =false;
				}
			}else {
				// fuera del rango
				mensajes.add("Ciudad no puede estar fuera del rango (Hasta 30 caracteres)");
				valid =false;
			}
		}else {
			// en blanco
			mensajes.add("Ciudad no puede ir en blanco");
			valid =false;
		}
		
		
		alumno.setTelefono(alumno.getTelefono().trim()); //Eliminamos posibles espacios en blanco
		if(!alumno.getTelefono().isBlank()) {
			if(alumno.getTelefono().length()>0 && alumno.getTelefono().length()<12) {
				if(this.isNumeric(alumno.getTelefono())) {
					mensajes.add("Teléfono ok");
				}else {
					mensajes.add("El Teléfono no es váido. Debe ser sólo numerico de la forma 9 1111 2222 o 911112222");
					valid =false;
				}
			}else {
				mensajes.add("El Teléfono ingresado esta fuera del rango");
				valid =false;
			}
		}else {
			mensajes.add("El Teléfono no puede ir en blanco");
			valid =false;
		}
		
		
		alumno.setCorreo(alumno.getCorreo().trim()); //Eliminamos posibles espacios en blanco
		if(!alumno.getCorreo().isBlank()) {
			if(alumno.getCorreo().length()>0 && alumno.getCorreo().length()<51) {
				if(this.validaEmail(alumno.getCorreo())) {
					mensajes.add("Correo ok");
				}else {
					mensajes.add("El Correo es inválido. Escriba de la forma nombre@dominio.dom");
					valid =false;
				}
			}else {
				mensajes.add("El Correo ingresado esta fuera del rango (Hasta 50 caracteres)");
				valid =false;
			}
		}else {
			mensajes.add("El Correo no puede ir en blanco");
			valid =false;
		}
		
		
		
		if(alumno.getRegion().isBlank()) {
			mensajes.add("No seleccionó una región");
			valid =false;
		}else {
			mensajes.add("Región ok");
		}
		
		if(valid) {
			as.modificarAlumno(alumno);
			mensajes.add("Alumno actualizado correctamente");
		}else {
			mensajes.add("Error al modificar Alumno");
		}
		attrs.addFlashAttribute("mensajes", mensajes);
		return "redirect:/admin/alumnos";
	}
	
	//Eliminar
	@RequestMapping(value="/alumno/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable("id") Long id, Model model, RedirectAttributes attrs) {
		as.eliminarAlumno(id);
		attrs.addFlashAttribute("message", "Alumno Eliminado");
		return "redirect:/admin/alumnos";
	}
	
	
	
	/* FUNCIONES DE AYUDA */
	
	private boolean validarRut(String rut) {

	    boolean validacion = false;
	    try {
	        rut =  rut.toUpperCase();
	        rut = rut.replace(".", "");
	        rut = rut.replace("-", "");
	        int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

	        char dv = rut.charAt(rut.length() - 1);

	        int m = 0, s = 1;
	        for (; rutAux != 0; rutAux /= 10) {
	            s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
	        }
	        if (dv == (char) (s != 0 ? s + 47 : 75)) {
	            validacion = true;
	        }

	    } catch (java.lang.NumberFormatException e) {
	    } catch (Exception e) {
	    }
	    return validacion;
	}
	
	
	private boolean isNumeric(String cadena) {
		cadena=cadena.replace(" ","");
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	private Boolean validaEmail(String email) {
		// Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");


        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            return true;
        } else {
            return false;
        }
	}
	
}
