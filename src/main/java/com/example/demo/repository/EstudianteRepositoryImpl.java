package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.merge(estudiante);
	}

	@Override
	public void actualizarParcial(String nombre, String apellido, Integer id) {
		// TODO Auto-generated method stub
		// JPQL
		// SQL UPDATE estudiante e set e.estu_nombre=:valor, e.estu_apellido=:valor2
		// WHERE e.estu_apellido:=valor3
		Query query = this.entityManager
				.createQuery("UPDATE Estudiante e SET e.nombre =:valor1 , e.apellido=:valor2 WHERE e.id=:valor3");
		query.setParameter("valor1", nombre);
		query.setParameter("valor2", apellido);
		query.setParameter("valor3", id);
		// Retorna un numero, la cantidad de registros que se actualizacion
		System.out.println("Actualizaciones realizadas" + query.executeUpdate());
	}

	@Override
	public Estudiante seleccionar(Integer id) {

		return this.entityManager.find(Estudiante.class, id);
	}

	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.seleccionar(id));
	}

}
