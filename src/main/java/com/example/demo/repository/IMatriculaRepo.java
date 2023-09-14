package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

public interface IMatriculaRepo {
	
	public void insertar(Matricula matricula);
	
	public List<Matricula> buscarTodos();
	
	public List<MatriculaDTO>  buscarDTO(); 
	

}
