package com.example.demo.service.to;

import java.io.Serializable;

import javax.persistence.Column;



public class MateriaTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private Integer id;
	private String nombre;
	private Integer credito;
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
	public Integer getCredito() {
		return credito;
	}
	public void setCredito(Integer credito) {
		this.credito = credito;
	}
}
