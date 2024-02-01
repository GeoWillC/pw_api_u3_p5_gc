package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.Estudiante;


public interface IEstudianteService {
	//Terminos de logica que maneja el negocio
	public void guardar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void actualizarParcial(String nombre, String apellido,Integer id);

	public Estudiante busqueda(Integer id);
	
	public void borrar(Integer id);
	
	public List<Estudiante> consultarTodo(String genero);
}
