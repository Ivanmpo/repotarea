package com.everis.data.services;


import java.util.List;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.everis.data.models.Cuenta;
import com.everis.data.repository.CuentaRepository;

@Service
public class CuentaService {

	
	@Autowired
	private CuentaRepository cr;


	public List<Cuenta> findAll() {
		return cr.findAll();
	}
	
	public Cuenta crearCuenta(@Valid Cuenta cuenta) {
		String hashed = BCrypt.hashpw(cuenta.getContrasena(), BCrypt.gensalt());
		cuenta.setContrasena(hashed);
		return cr.save(cuenta);
	}
	
	public Cuenta findById(Long id) {
		return cr.getById(id);
	}
	
	public void modificarCuenta(@Valid Cuenta cuenta) {
		cr.save(cuenta);
	}
	
	public void eliminarCuenta(Long id) {
		cr.deleteById(id);
	}
	
	
	public boolean validarCuenta(String usuario, String password) {
		Cuenta cuenta = cr.findByNombreUsuario(usuario);
		if(cuenta == null) {
			return false;
		}else {
			//comparar los password
			if (BCrypt.checkpw(password, cuenta.getContrasena())) {
			    System.out.println("Password iguales");
				return true;
				
			}else {
			    System.out.println("Password Distintos");
			    return false;
			}
		}
	}
	
	public Cuenta findByNombreUsuario(String usuario) {
		
		return cr.findByNombreUsuario(usuario);
		
	}
}
