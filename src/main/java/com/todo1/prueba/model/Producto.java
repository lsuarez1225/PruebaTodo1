package com.todo1.prueba.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String nombre;
	
	@Column
	private String descripcion;
	
	@Column
	private Double precio;
	
	@Column
	private LocalDate fechacreacion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public LocalDate getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(LocalDate fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	
}
