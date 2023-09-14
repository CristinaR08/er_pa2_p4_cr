package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepo;
import com.example.demo.repository.modelo.Materia;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MateriaServiceImpl implements IMateriaService{
	
	@Autowired
	private IMateriaRepo materiaRepo;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Materia materia) {
		//se inicia en 0 el sestudiante
		materia.setNumeroEstudiantes(0);
		this.materiaRepo.insertar(materia);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Materia buscarPorCodigo(String codigo) {
		return this.materiaRepo.buscarCodigo(codigo);
	}

	@Override
	public List<Materia> listaMaterias() {
		return this.materiaRepo.mostrarTodo();
	}
	
	

}
