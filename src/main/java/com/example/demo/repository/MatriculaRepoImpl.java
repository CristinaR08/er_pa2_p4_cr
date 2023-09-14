package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MatriculaRepoImpl implements IMatriculaRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Matricula matricula) {
		this.entityManager.merge(matricula);

	}

	@Override
	public List<Matricula> buscarTodos() {
		TypedQuery<Matricula> query = this.entityManager.createQuery("SELECT ma FROM Matricula ma", Matricula.class);
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<MatriculaDTO> buscarDTO() {
		TypedQuery<MatriculaDTO> myTypedQuery = this.entityManager.createQuery(
				"SELECT NEW com.example.demo.repository.modelo.dto.MatriculaDTO (m.estudiante.cedula, m.estudiante.apellido,m.estudiante.nombre, m.materia.codigo, m.fecha) FROM Matricula m",
				MatriculaDTO.class);
		try {
			return myTypedQuery.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

}
