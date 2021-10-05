package com.everis.data.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="cuentas")
public class Cuenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrementar
	private Long id;
	private String nombre_usuario;
	private String contrasena;

	//Fechas
	@Column(updatable=false)
	@CreationTimestamp
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
		
	@UpdateTimestamp
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
 
	
	
		
	public Cuenta() {
		super();
	}



	public Cuenta(String nombre_usuario, String contraseña) {
		super();
		this.nombre_usuario = nombre_usuario;
		this.contrasena = contraseña;
	}


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNombre_usuario() {
		return nombre_usuario;
	}



	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}



	public String getContraseña() {
		return contrasena;
	}


	public void setContraseña(String contraseña) {
		this.contrasena = contraseña;
	}



	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	
	
		
		
}
