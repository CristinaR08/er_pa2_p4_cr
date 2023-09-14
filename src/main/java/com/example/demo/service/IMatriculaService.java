package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.MatriculaTemporal;
import com.example.demo.repository.modelo.dto.MatriculaDTO;


public interface IMatriculaService {
	
	public void insertar(Matricula matricula);
	
	
	public void agregarMatricula(MatriculaTemporal mTemporal);
	
	
	public List<Matricula> buscarTodos();
	
	public List<MatriculaDTO>  buscarDTO(); 
	

}
