package com.everis.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.data.models.Alumno;


@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{

	

}
