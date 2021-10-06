package com.everis.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.everis.data.models.Cuenta;
import com.everis.data.repository.CuentaRepository;
import com.everis.data.services.CuentaService;

@Component
public class CommandLineAntesInicio implements CommandLineRunner{
	
	
	@Autowired
	CuentaRepository cR;
	
	@Autowired
	CuentaService cS;
	
	
	
	@Override
	public void run(String[] args) throws Exception{
		//cR.deleteByTipoUsuario((byte)1);
		cR.deleteAll();
		
		
		Cuenta cuentaAdmin = new Cuenta("Admin", "Admin123$",(byte) 1);
		cS.crearCuenta(cuentaAdmin);
		
	}
	
	
}
