package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	//url = http://localhost:8080:/API/V1.0/Matricula/estudiantes  /buscar
	
	// GET
	@GetMapping(path = "/buscar")
	public Estudiante buscar() {
		return iEstudianteService.busqueda(0);
	}
	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Estudiante estudiante) {
		this.iEstudianteService.guardar(estudiante);
	}
}
