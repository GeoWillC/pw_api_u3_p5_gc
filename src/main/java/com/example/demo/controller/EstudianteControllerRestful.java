package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IMateriaService;
import com.example.demo.service.to.EstudianteTO;
import com.example.demo.service.to.MateriaTO;

//SERVICIO
@RestController
@RequestMapping(path = "/estudiantes")
public class EstudianteControllerRestful {

	@Autowired
	private IEstudianteService iEstudianteService;
	
	@Autowired
	private IMateriaService iMateriaService;

	// CAPACIDAD Y TIPO DE VERBO
	// Metodos y verbos http
	// url = http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar
	// PATH VARIABLE:
	// ......../consulta/3
	// ......../consulta/{id}
	// GET
	//Se puede stakear varios path variables  pero se debe agregar en la firma
	///consultar/{id}/{nombre}
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/{id} GET
	@GetMapping(path = "/{id}",produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Estudiante> buscar(@PathVariable Integer id) {
		Estudiante estu = this.iEstudianteService.busqueda(id);
		return ResponseEntity.status(241).body(estu);
	}
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<List<EstudianteTO>> buscarTodoHateoas(@RequestParam(required = false,defaultValue = "M") String genero) {
		//Quemado con fin didactico
		List<EstudianteTO> lista = this.iEstudianteService.consultarTodoTo();
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	//URL DE MATERIAS
	//http://localhost:8082/API/v1.0/Matricula/estudiantes/1/materias 	GET
	@GetMapping(path = "/{id}/materias",produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<List<MateriaTO>> consultarMateriasId(@PathVariable Integer id) {
		List<MateriaTO> lista= this.iMateriaService.buscarPorIdEstudiante(id);
		//return ResponseEntity.status(241).body(this.iMateriaService.buscarPorIdEstudiante(id));
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
	public void guardar(@RequestBody Estudiante estudiante) {
		this.iEstudianteService.guardar(estudiante);
	}

	@PutMapping(path = "/{id}",consumes = MediaType.APPLICATION_XML_VALUE)
	public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		estudiante.setId(id);
		this.iEstudianteService.actualizar(estudiante);
	}

	@PatchMapping(path = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizarParcial(@RequestBody Estudiante estudiante,@PathVariable Integer id) {
		this.iEstudianteService.actualizarParcial(estudiante.getName(), estudiante.getApellido(), id);
	}

	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		this.iEstudianteService.borrar(id);
	}

//	@GetMapping(path = "/consultarTodo")
//	public List<Estudiante> buscarTodo() {
//		return iEstudianteService.consultarTodo();
//	}
	// url =
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/consultarTodo?genero=M&edad=100
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes GET si no hay request param
	


	
}
