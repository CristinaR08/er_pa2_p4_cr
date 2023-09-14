package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class MateriaRepoImpl implements IMateriaRepo{

	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Materia materia) {
		this.entityManager.persist(materia);
		
		
	}
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Materia buscarCodigo(String codigo) {
		TypedQuery<Materia> query = this.entityManager.createQuery("SELECT m FROM Materia m where m.codigo =:datoCodigo", Materia.class);
		query.setParameter("datoCodigo", codigo);
		try {
			return query.getResultList().get(0);
		} catch (NoResultException e) {
			return null;
		}
		
	}
	@Override
	public List<Materia> mostrarTodo() {
		TypedQuery<Materia> lista = this.entityManager.createQuery("SELECT m FROM Materia m",Materia.class);
		try {
			return lista.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	

}
