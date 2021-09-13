package com.todo1.prueba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.todo1.prueba.model.CarroCompras;

@SpringBootApplication
public class Todo1Application implements CommandLineRunner {

	@Autowired
	private JdbcTemplate template;
	
	public static void main(String[] args) {
		SpringApplication.run(Todo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// TODO Auto-generated method stub
		template.execute("DROP TABLE usuario IF EXISTS");
		template.execute("DROP TABLE productos IF EXISTS");
		template.execute("DROP TABLE carrito IF EXISTS");
	
		template.execute("CREATE TABLE usuario(id IDENTITY PRIMARY KEY auto_increment, username VARCHAR(50) NOT NULL, name VARCHAR(255) NOT NULL, lastname VARCHAR(255) NOT NULL, password VARCHAR(100) NOT NULL, active BOOLEAN DEFAULT TRUE, entereddate DATETIME DEFAULT CURRENT_TIMESTAMP)");
		template.execute("CREATE TABLE productos(id IDENTITY PRIMARY KEY auto_increment, nombre VARCHAR(100) NOT NULL, descripcion VARCHAR(350), precio DOUBLE NOT NULL DEFAULT 0, fechacreacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP)");
		template.execute("CREATE TABLE carrito(id IDENTITY PRIMARY KEY auto_increment, userid INTEGER NOT NULL, productid INTEGER NOT NULL, cantidad INTEGER NOT NULL, precio DOUBLE DEFAULT 0, fecha DATETIME DEFAULT CURRENT_TIMESTAMP)");
		
		template.execute("INSERT INTO usuario(id, username, name, lastname, password) VALUES (1, 'admin', 'Admin', 'Administrador', '123')");
		
		template.execute("INSERT INTO productos(nombre, descripcion, precio) VALUES ('producto 1', 'Descripción producto 1', 1000)");
		template.execute("INSERT INTO productos(nombre, descripcion, precio) VALUES ('producto 2', 'Descripción producto 2', 3000)");
		template.execute("INSERT INTO productos(nombre, descripcion, precio) VALUES ('producto 3', 'Descripción producto 3', 7000)");
		template.execute("INSERT INTO productos(nombre, descripcion, precio) VALUES ('producto 4', 'Descripción producto 4', 2000)");
		template.execute("INSERT INTO productos(nombre, descripcion, precio) VALUES ('producto 5', 'Descripción producto 5', 6000)");
		template.execute("INSERT INTO productos(nombre, descripcion, precio) VALUES ('producto 6', 'Descripción producto 6', 9000)");
	}
}
