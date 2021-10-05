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
	private byte tipo_usuario;
	private boolean activo;

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



	public Cuenta(String nombre_usuario, String contraseña, byte tipo_usuario) {
		super();
		this.nombre_usuario = nombre_usuario;
		this.contrasena = contraseña;
		this.tipo_usuario=tipo_usuario;
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



	public String getContrasena() {
		return contrasena;
	}



	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}



	public boolean isActivo() {
		return activo;
	}



	public void setActivo(boolean activo) {
		this.activo = activo;
	}



	public byte getTipo_usuario() {
		return tipo_usuario;
	}



	public void setTipo_usuario(byte tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
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
