package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepo;
import com.example.demo.repository.IMateriaRepo;
import com.example.demo.repository.IMatriculaRepo;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.MatriculaTemporal;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MatriculaServiceImpl implements IMatriculaService{

	
	@Autowired
	private IMatriculaRepo matriculaRepo;
	
	@Autowired
	private IMateriaRepo materiaRepo;
	
	@Autowired
	private IEstudianteRepo estudianteRepo;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Matricula matricula) {
		this.matriculaRepo.insertar(matricula);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void agregarMatricula(MatriculaTemporal mTemporal) {
		Materia meteria = this.materiaRepo.buscarCodigo(mTemporal.getCodigo());
		Estudiante estudiante = this.estudianteRepo.buscarPorCedula(mTemporal.getCedula());
		
		Matricula matricula = new Matricula();
		matricula.setEstudiante(estudiante);
		matricula.setMateria(meteria);
		matricula.setFecha(LocalDate.now());
		meteria.setNumeroEstudiantes(meteria.getNumeroEstudiantes()+1);
		this.insertar(matricula);		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Matricula> buscarTodos() {
		return this.matriculaRepo.buscarTodos();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<MatriculaDTO> buscarDTO() {
		return this.matriculaRepo.buscarDTO();
	}
	

}
