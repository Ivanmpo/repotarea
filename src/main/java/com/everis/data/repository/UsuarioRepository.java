package com.everis.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.data.models.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByCorreo(String correo);

}
