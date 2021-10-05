package com.everis.data.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.everis.data.models.Usuario;
import com.everis.data.services.UsuarioService;

@Controller
public class UsuarioController {

	//@Autowired
	//private UsuarioService usss;

	
	@RequestMapping("/")
	public String inicio(HttpSession session) {
		return "redirect:/home";
	}
	
	@RequestMapping("/home")
	public String home(HttpSession session) {
		
		return "home.jsp";

	}
	
	@RequestMapping("/alumnos")
	public String alumnos(HttpSession session) {
		
		return "listado_alumnos.jsp";

	}
	
	@RequestMapping("/login")
	public String login() {
		return "login.jsp";
	}
	
	@RequestMapping("/ingresar")
	public String ingresar(@RequestParam("usuario") String usuario, @RequestParam("password") String password, HttpSession session ) {

		return "redirect:/login";
	}
	
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("userId")!=null  ) {
			session.invalidate(); //Matamos todas las variables de session
		}
		return "redirect:/login";
	}
	
	
}
