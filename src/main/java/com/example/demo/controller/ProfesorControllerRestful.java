package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Profesor;
import com.example.demo.service.IProfesorService;

@RestController
@RequestMapping(path = "/profesores")
public class ProfesorControllerRestful {

	@Autowired
	private IProfesorService iProfesorService;
	
	
	//buscar
	@GetMapping(path="/consultar/{id}")
	public Profesor consultar(@PathVariable Integer id) {
		System.out.println(this.iProfesorService.busqueda(id));
		return this.iProfesorService.busqueda(1);
	}
	@PostMapping(path="/guardar")
	public void guardar(@RequestBody Profesor profesor) {
		this.iProfesorService.guardar(profesor);		
	}
	@PutMapping(path = "/actualizar")
	public void actualizar(@RequestBody Profesor profesor) {
		this.iProfesorService.actualizar(profesor);
	}
	@PatchMapping(path = "/actualizarParcial")
	public void actualizarParcial(@RequestBody Profesor profesor) {
		this.iProfesorService.actualizarParcial(profesor.getNombre(), profesor.getApellido(), profesor.getId());
	}
	@DeleteMapping(path = "/borrar/{id}")
	public void borrar(@PathVariable Integer id) {
		this.iProfesorService.borrar(id);
	}
	@GetMapping(path = "/consultarTodo")
	public List<Profesor> consultarTodo(@RequestParam String genero){
	System.out.println("Genero "+ genero);
		return this.iProfesorService.consultarTodo(genero);		
	}
	
}
