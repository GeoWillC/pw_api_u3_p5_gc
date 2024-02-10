package com.example.demo.repository.modelo;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="estudiante")
public class Estudiante {
	@Id
	//@GeneratedValue el nombre de la @SequenceGenerator sequenceName
	@GeneratedValue(generator = "seq_estudiante",strategy = GenerationType.AUTO )
	@SequenceGenerator(name="seq_estudiante", sequenceName = "seq_estudiante",allocationSize = 1)
	@Column(name="estu_id")
	private Integer id;
	@Column(name="estu_name")
	private String name;
	@Column(name="estu_apellido")
	private String apellido;
	@Column(name="estu_genero")
	private String genero;
	@Column(name="estu_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;
	//https://stackoverflow.com/questions/73566546/how-to-solve-at-com-fasterxml-jackson-databind-error
	@JsonManagedReference
	@OneToMany(mappedBy = "estudiante" )
	private List<Materia>  materia;
	//GET Y SET
	public List<Materia> getMaterias() {
		return materia;
	}
	public void setMaterias(List<Materia> materias) {
		this.materia = materias;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
}
