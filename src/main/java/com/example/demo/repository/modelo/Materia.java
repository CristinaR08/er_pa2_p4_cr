package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name= "materia")
public class Materia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_materia")
	@SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia", allocationSize = 1)
	@Column(name = "mat_id")
	private Integer id;
	
	@Column(name = "mat_nombre")
	private String nombre;
	
	@Column(name = "mat_codigo")
	private String codigo;
	
	@Column(name = "mat_descripcion")
	private String descripcion;
	
	@Column(name = "mat_numero_creditos")
	private Integer numeroCreditos ;
	
	@Column(name = "mat_numero_estudiantes")
	private Integer numeroEstudiantes;
	
	@OneToMany(mappedBy="materia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Matricula> matriculas;
	
	@Override
	public String toString() {
		return "Materia [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", descripcion=" + descripcion
				+ ", numeroCreditos=" + numeroCreditos + ", numeroEstudiantes=" + numeroEstudiantes + "]";
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getNumeroCreditos() {
		return numeroCreditos;
	}

	public void setNumeroCreditos(Integer numeroCreditos) {
		this.numeroCreditos = numeroCreditos;
	}

	public Integer getNumeroEstudiantes() {
		return numeroEstudiantes;
	}

	public void setNumeroEstudiantes(Integer numeroEstudiantes) {
		this.numeroEstudiantes = numeroEstudiantes;
	}
	
	
	
	
	
	

}
