package com.everis.data.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Usuario;
import com.everis.data.repository.UsuarioRepository;

@Service
public class UsuarioService {

	
	@Autowired
	private UsuarioRepository ur;


	public Usuario findByUsuario(String email) {
		return ur.findByCorreo(email);
	}
	
	public Usuario findById(Long id) {
		return ur.getById(id);
	}
	
}
