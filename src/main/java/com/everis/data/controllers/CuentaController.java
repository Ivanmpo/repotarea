package com.everis.data.controllers;

import java.util.LinkedHashMap;
import java.util.Map;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	/*
	@RequestMapping("/login")
	public String login() {
		return "login.jsp";
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("userId")!=null  ) {
			session.invalidate(); //Matamos todas las variables de session
		}
		return "redirect:/login";
	}
	
	@RequestMapping("/ingresar")
	public String ingresar(@RequestParam("usuario") String usuario, @RequestParam("password") String password, HttpSession session ) {

		return "redirect:/login";
	}
	*/
	
	//Crear
	@RequestMapping(value="/crear", method =RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("cuenta") Cuenta cuenta, RedirectAttributes attrs) {
		cuenta.setTipo_usuario((byte) 2);
		cs.crearCuenta(cuenta);
		attrs.addFlashAttribute("message", "Usuario Creado");
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
	public String actualizar(@Valid @ModelAttribute("cuenta") Cuenta cuenta, RedirectAttributes attrs) {
		cs.modificarCuenta(cuenta);
		attrs.addFlashAttribute("message", "Usuario Modificado");
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
