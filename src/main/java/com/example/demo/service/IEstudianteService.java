package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;


public interface IEstudianteService {
	
	public void insertar(Estudiante estudiante);

	public Estudiante buscar(Integer id);

	// Para ver la lista de los estudiantes
	public List<Estudiante> buscarTodos();
	
	public Estudiante buscarCedula(String cedula);

}
