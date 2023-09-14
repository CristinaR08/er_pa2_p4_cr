package com.example.demo.repository.modelo.dto;

import java.time.LocalDate;

public class MatriculaDTO {

	private String cedula;
	private String apellido;
	private String nombre;
	private String codigoMateria;
	private LocalDate fechaMatricula;
	
	public MatriculaDTO() {
		
	}
	
	public MatriculaDTO(String cedula, String apellido, String nombre, String codigoMateria, LocalDate fechaMatricula) {
		super();
		this.cedula = cedula;
		this.apellido = apellido;
		this.nombre = nombre;
		this.codigoMateria = codigoMateria;
		this.fechaMatricula = fechaMatricula;
	}

	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getCodigoMateria() {
		return codigoMateria;
	}
	public void setCodigoMateria(String codigoMateria) {
		this.codigoMateria = codigoMateria;
	}

	public LocalDate getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(LocalDate fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}
	
	
	
}
