package com.everis.data.controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.everis.data.models.Cuenta;
import com.everis.data.services.CuentaService;

@RequestMapping("/admin/cuentas")
@Controller
public class CuentaController {

	@Autowired
	private CuentaService cs;

	
	@RequestMapping("")
	public String index() {
		return "redirect:/admin/cuentas/";
	}
	
	@RequestMapping("/")
	public String listadoCuentas(@ModelAttribute("cuenta") Cuenta cuenta, Model model) {
		model.addAttribute("lista_usuarios", cs.findAll());
		return "listado_usuarios.jsp";
	}

	
	
	
	//Crear
	@RequestMapping(value="/crear", method =RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("cuenta") Cuenta cuenta, RedirectAttributes attrs) {
		
		boolean valid = true;
		List<String> mensajes = new ArrayList<String>();
		
		cuenta.setNombreUsuario(cuenta.getNombreUsuario().trim()); //Eliminamos posibles espacios en blanco
		if(!cuenta.getNombreUsuario().isBlank()) {
			if(cuenta.getNombreUsuario().length()>0 && cuenta.getNombreUsuario().length()<11) {
				mensajes.add("Nombre Ok");
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
		
		//cuenta.setContrasena(cuenta.getContrasena().trim()); //Eliminamos posibles espacios en blanco
		if(!cuenta.getContrasena().isBlank()) {
			if(cuenta.getContrasena().length()>0 && cuenta.getContrasena().length()<9) {
				mensajes.add("Contraseña Ok");
			}else {
				// fuera del rango
				mensajes.add("Contraseña no puede estar fuera del rango");
				valid = false;
			}
		}else {
			// en blanco
			mensajes.add("La contraseña no puede ir en blanco");
			valid = false;
		}
		
		if(valid) {
			cuenta.setTipoUsuario((byte) 2);
			cs.crearCuenta(cuenta);	
		}else {
			mensajes.add("Error al crear usuario");
		}
		
		attrs.addFlashAttribute("mensajes", mensajes);
		return "redirect:/admin/cuentas/";
	}
	
	//Actualizar y modificar
	
	@RequestMapping(value="/modificar/{id}", method = RequestMethod.GET)
	public String modificar(@PathVariable("id") Long id, Model model) {
		Cuenta cuenta = cs.findById(id);
		Map<String,String> activoList = new LinkedHashMap<String,String>();
		activoList.put("0", "Desactivado");
		activoList.put("1", "Activo");
		model.addAttribute("cuenta", cuenta);
		model.addAttribute("activoList", activoList);
		return "editar_usuario.jsp";
	}
		
	@RequestMapping(value="/actualizar", method=RequestMethod.PUT)
	public String actualizar(@Valid @ModelAttribute("cuenta") Cuenta cuenta, RedirectAttributes attrs, @RequestParam(value="contrasena", required=false) String contrasena) {
		
		
		boolean valid = true;
		List<String> mensajes = new ArrayList<String>();
		
		if(contrasena!=null && !contrasena.isBlank() && !contrasena.isEmpty()) {
			cuenta.setContrasena(BCrypt.hashpw(contrasena, BCrypt.gensalt()));
		}
		
		cuenta.setNombreUsuario(cuenta.getNombreUsuario().trim()); //Eliminamos posibles espacios en blanco
		if(!cuenta.getNombreUsuario().isBlank()) {
			if(cuenta.getNombreUsuario().length()>0 && cuenta.getNombreUsuario().length()<11) {
				mensajes.add("Nombre Ok");
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
		
		//cuenta.setContrasena(cuenta.getContrasena().trim()); //Eliminamos posibles espacios en blanco
		if(!cuenta.getContrasena().isBlank()) {
			if(cuenta.getContrasena().length()>0 && cuenta.getContrasena().length()<9) {
				mensajes.add("Contraseña Ok");
			}else {
				// fuera del rango
				mensajes.add("Contraseña no puede estar fuera del rango");
				valid = false;
			}
		}else {
			// en blanco
			mensajes.add("La contraseña no puede ir en blanco");
			valid = false;
		}
		
		if(valid) {
			cs.modificarCuenta(cuenta);
			mensajes.add("Usuario modificado correctamente");
		}else {
			mensajes.add("Error al modificar usuario");
		}

		attrs.addFlashAttribute("mensajes", mensajes);
		return "redirect:/admin/cuentas/";
	}
	
	//Eliminar
	@RequestMapping(value="/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable("id") Long id, Model model, RedirectAttributes attrs) {
		cs.eliminarCuenta(id);
		attrs.addFlashAttribute("message", "Usuario Eliminado");
		return "redirect:/admin/cuentas/";
	}
}
