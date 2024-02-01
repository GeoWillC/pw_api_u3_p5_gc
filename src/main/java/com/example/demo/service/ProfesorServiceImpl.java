package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IProfesorRepository;
import com.example.demo.repository.modelo.Profesor;

@Service
public class ProfesorServiceImpl implements IProfesorService{
	
	@Autowired
	private IProfesorRepository iProfesorRepository;

	@Override
	public void guardar(Profesor profesor) {
		// TODO Auto-generated method stub
		this.iProfesorRepository.insertar(profesor);
	}

	@Override
	public void actualizar(Profesor profesor) {
		// TODO Auto-generated method stub
		this.iProfesorRepository.actualizar(profesor);
	}

	@Override
	public void actualizarParcial(String nombre, String apellido, Integer id) {
		// TODO Auto-generated method stub
		this.iProfesorRepository.actualizarParcial(nombre, apellido, id);
	}

	@Override
	public Profesor busqueda(Integer id) {
		// TODO Auto-generated method stub
		return this.iProfesorRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iProfesorRepository.eliminar(id);
	}

	@Override
	public List<Profesor> consultarTodo(String genero) {
		// TODO Auto-generated method stub
		return this.iProfesorRepository.consultarTodo(genero);
	}
}
