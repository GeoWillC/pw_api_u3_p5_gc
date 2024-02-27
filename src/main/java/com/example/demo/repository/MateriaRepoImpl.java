package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Materia;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepoImpl implements IMateriaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Materia> seleccionarPorIdEstudiante(Integer id) {
		//JPQL SELECT M
		TypedQuery<Materia> myQuery= this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.estudiante.id=:id",Materia.class);
		myQuery.setParameter("id",id);
		
		return myQuery.getResultList();
	}

}
