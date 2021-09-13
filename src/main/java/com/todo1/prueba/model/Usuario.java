package com.todo1.prueba.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column
	private String username;
	
	@Column
	private String name;
	
	@Column
	private String lastname;
	
	@Column
	private String password;
	
	@Column
	private Boolean active;
	
	@Column
	private LocalDate entereddate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public LocalDate getEntereddate() {
		return entereddate;
	}

	public void setEntereddate(LocalDate entereddate) {
		this.entereddate = entereddate;
	}
	
}
