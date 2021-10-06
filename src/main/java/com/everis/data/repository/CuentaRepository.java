package com.everis.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.data.models.Cuenta;


@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long>{

	Cuenta deleteByTipoUsuario(byte tipo);
	Cuenta findByNombreUsuario(String nombreUsuario);
}
