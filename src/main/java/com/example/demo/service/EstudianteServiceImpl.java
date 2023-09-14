package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepo;
import com.example.demo.repository.modelo.Estudiante;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

	
	@Autowired
	private IEstudianteRepo estudianteRepo;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Estudiante estudiante) {
		this.estudianteRepo.insertar(estudiante);
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Estudiante buscar(Integer id) {
		return this.estudianteRepo.buscar(id);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Estudiante> buscarTodos() {
		return this.estudianteRepo.buscarTodos();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Estudiante buscarCedula(String cedula) {
		return this.estudianteRepo.buscarPorCedula(cedula);
	}
	

}
