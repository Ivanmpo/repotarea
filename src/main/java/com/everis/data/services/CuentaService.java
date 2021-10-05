package com.everis.data.services;


import java.util.List;

import javax.validation.Valid;

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
}
