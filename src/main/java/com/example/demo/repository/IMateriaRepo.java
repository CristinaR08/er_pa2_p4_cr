package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaRepo {
	
	public  void insertar(Materia materia);
	
	public Materia buscarCodigo(String codigo);
	
	public List<Materia> mostrarTodo();
	
	

}
