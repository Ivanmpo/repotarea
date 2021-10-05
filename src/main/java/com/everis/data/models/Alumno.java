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
@Table(name="alumnos")
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrementar
	private Long id;
	private String nombre;
	private String segundo_nombre;
	private String apellido_paterno;
	private String apellido_materno;
	private String rut; // 12345789-1
	private String direccion;
	private String ciudad;
	private String region;
	private String correo;
	private String telefono;

	//Fechas
	@Column(updatable=false)
	@CreationTimestamp 
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
		
	@UpdateTimestamp
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
 

	
	public Alumno() {
		super();
	}


	public Alumno(String nombre, String segundo_nombre, String apellido_paterno, String apellido_materno, String rut,
			String direccion, String ciudad, String region, String correo, String telefono) {
		super();
		this.nombre = nombre;
		this.segundo_nombre = segundo_nombre;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		this.rut = rut;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.region = region;
		this.correo = correo;
		this.telefono = telefono;
	}





	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public String getSegundo_nombre() {
		return segundo_nombre;
	}





	public void setSegundo_nombre(String segundo_nombre) {
		this.segundo_nombre = segundo_nombre;
	}





	public String getApellido_paterno() {
		return apellido_paterno;
	}





	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}





	public String getApellido_materno() {
		return apellido_materno;
	}





	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}





	public String getRut() {
		return rut;
	}





	public void setRut(String rut) {
		this.rut = rut;
	}





	public String getDireccion() {
		return direccion;
	}





	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}





	public String getCiudad() {
		return ciudad;
	}





	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}





	public String getRegion() {
		return region;
	}





	public void setRegion(String region) {
		this.region = region;
	}





	public String getCorreo() {
		return correo;
	}





	public void setCorreo(String correo) {
		this.correo = correo;
	}





	public String getTelefono() {
		return telefono;
	}





	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
