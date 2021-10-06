package com.everis.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.everis.data.models.Cuenta;


@Repository 
public interface CuentaRepository extends JpaRepository<Cuenta, Long>{


	Cuenta findByNombreUsuario(String nombreUsuario);
	
	
    List<Cuenta> findAllByTipoUsuario(byte tipoUsuario); 

}
