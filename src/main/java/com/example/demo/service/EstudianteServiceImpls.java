package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

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

	@Override
	public List<EstudianteTO> consultarTodoTo() {
		// TODO Auto-generated method stub
		//Conversion de Estudiante a EstudianteTO
		List<Estudiante> lista=this.iEstudianteRepository.consultarTodo("M");
		List<EstudianteTO> listaFinal=new ArrayList<>();
		for(Estudiante est:lista) {
			listaFinal.add(this.conversorTO(est));
		}
		return listaFinal;
	}
	private EstudianteTO conversorTO(Estudiante est) {
		EstudianteTO estuTo=new EstudianteTO();
		estuTo.setName(est.getName());
		estuTo.setApellido(est.getApellido());
		estuTo.setGenero(est.getGenero());
		estuTo.setId(est.getId());
		estuTo.setFechaNacimiento(est.getFechaNacimiento());
		return estuTo;
	}

	@Override
	public EstudianteTO busquedaTO(Integer id) {
		// TODO Auto-generated method stub
		return this.conversorTO(this.iEstudianteRepository.seleccionar(id));
	}

	
}
