package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class EstudianteRepoImpl implements IEstudianteRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
	}


	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Estudiante buscar(Integer id) {
		return this.entityManager.find(Estudiante.class, id);

	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Estudiante> buscarTodos() {
		TypedQuery<Estudiante> query = this.entityManager.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
		return query.getResultList();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Estudiante buscarPorCedula(String cedula) {
		TypedQuery<Estudiante> query = this.entityManager.createQuery("SELECT e FROM Estudiante e where e.cedula=:datoCedula", Estudiante.class);
		query.setParameter("datoCedula", cedula);
		return query.getResultList().get(0);
		
	}


}
