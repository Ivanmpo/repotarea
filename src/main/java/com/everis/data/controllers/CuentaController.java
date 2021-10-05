package com.everis.data.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CuentaController {

	
	@RequestMapping("/")
	public String index() {
		return "login.jsp";
	}
	
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
	/*
	@RequestMapping("/ingresar")
	public String ingresar(@RequestParam("usuario") String usuario, @RequestParam("password") String password, HttpSession session ) {

		return "redirect:/login";
	}
	*/
}
