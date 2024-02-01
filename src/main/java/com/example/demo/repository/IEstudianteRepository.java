package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteRepository {
	//CRUD create, read, update (total, parcial), delete
	public void insertar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void actualizarParcial(String nombre, String apellido,Integer id);

	public Estudiante seleccionar(Integer id);
	
	public void eliminar(Integer id);
	
	public List<Estudiante> consultarTodo(String genero);
}
