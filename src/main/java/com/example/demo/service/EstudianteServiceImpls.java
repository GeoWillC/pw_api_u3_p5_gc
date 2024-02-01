package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpls implements IEstudianteService{

	@Autowired
	private IEstudianteRepository iEstudianteRepository;
	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.iEstudianteRepository.insertar(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.iEstudianteRepository.actualizar(estudiante);
	}

	@Override
	public void actualizarParcial(String nombre, String apellido, Integer id) {
		// TODO Auto-generated method stub
		this.iEstudianteRepository.actualizarParcial(nombre, apellido, id);
	}

	@Override
	public Estudiante busqueda(Integer id) {
		// TODO Auto-generated method stub
		return this.iEstudianteRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iEstudianteRepository.eliminar(id);
	}

	@Override
	public List<Estudiante> consultarTodo(String genero) {
		// TODO Auto-generated method stub
		return this.iEstudianteRepository.consultarTodo(genero);
	}
	
}
