package com.everis.data.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.everis.data.models.Cuenta;
import com.everis.data.services.CuentaService;


@Controller
public class InicioController {

	@Autowired
	private CuentaService cs;
	
	@RequestMapping("/")
	public String inicio() {
		return "redirect:/admin/login";
	}
	
	@RequestMapping("/admin")
	public String incio2() {
		return "redirect:/admin/login";
	}
	
	@RequestMapping("/admin/home")
	public String home(HttpSession session, RedirectAttributes attrs ) {
		if(session.getAttribute("userId")==null  ) {
			attrs.addFlashAttribute("message", "No ha iniciado sesión");
			return "redirect:/admin/login";	
		}
		
		
		return "home.jsp";
	}
	
	
	
	@RequestMapping("/admin/login")
	public String login() {
		return "login.jsp";
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("userId")!=null  ) {
			session.invalidate(); //Matamos todas las variables de session
		}
		return "redirect:/admin/login";
	}
	
	@RequestMapping("/ingresar")
	public String ingresar(@RequestParam("nombreUsuario") String usuario, 
							@RequestParam("password") String password, 
							HttpSession session ) {
		boolean existeUsuario = cs.validarCuenta(usuario, password);
		if(existeUsuario) {
			Cuenta user = cs.findByNombreUsuario(usuario);
			//guardando un elemento en session
			session.setAttribute("userId", user.getId());
			session.setAttribute("nombreUsuario", user.getNombreUsuario());
			return "redirect:/admin/home";
		}
		return "redirect:/";
	}
}
