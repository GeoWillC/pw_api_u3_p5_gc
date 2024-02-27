package com.example.demo.repository.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="profesor")
public class Profesor {
	@Id
	//@GeneratedValue el nombre de la @SequenceGenerator sequenceName
	@GeneratedValue(generator = "seq_profesor",strategy = GenerationType.AUTO )
	@SequenceGenerator(name="seq_profesor", sequenceName = "seq_profesor",allocationSize = 1)
	@Column(name="prof_id")
	private Integer id;
	@Column(name="prof_nombre")
	private String nombre;
	@Column(name="prof_apellido")
	private String apellido;
	@Column(name="prof_cedula")
	private String cedula;
	@Column(name="prof_genero")
	private String genero;
	@Column(name="prof_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;
	@Column(name="prof_edad")
	private String edad;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
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
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	
	//GET Y SET
	
	
}
