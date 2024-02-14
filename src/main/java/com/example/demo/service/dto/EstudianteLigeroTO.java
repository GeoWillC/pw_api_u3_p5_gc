package com.example.demo.service.dto;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.example.demo.service.to.EstudianteTO;

public class EstudianteLigeroTO extends RepresentationModel<EstudianteTO> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String apellido;
	private String cedula;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
