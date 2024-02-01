package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

//SERVICIO
@RestController
@RequestMapping(path = "/estudiantes")
public class EstudianteControllerRestful {

	@Autowired
	private IEstudianteService iEstudianteService;

	// CAPACIDAD Y TIPO DE VERBO
	// Metodos y verbos http

	//url = http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar
	
	// GET
	@GetMapping(path = "/consultar")
	public Estudiante buscar() {
		System.out.println(iEstudianteService.busqueda(0));
		return iEstudianteService.busqueda(0);
	}
	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Estudiante estudiante) {
		this.iEstudianteService.guardar(estudiante);
	}
	@PutMapping(path="/actualizar")
	public void actualizar(@RequestBody Estudiante estudiante) {
		this.iEstudianteService.actualizar(estudiante);
	}
	@PatchMapping(path = "/actualizarParcial")
	public void actualizarParcial(@RequestBody Estudiante estudiante) {
		this.iEstudianteService.actualizarParcial(estudiante.getName(),estudiante.getApellido(), estudiante.getId());
	}
	@DeleteMapping(path = "borrar")
	public void borrar() {
		this.iEstudianteService.borrar(2);
	}
}
