package com.todo1.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.todo1.prueba.model.Producto;
import com.todo1.prueba.service.ProductoService;

@Controller
public class LoginController {
	
	@GetMapping(value = "/login")
	public String login() {
		return "pages/login";
	}

}
