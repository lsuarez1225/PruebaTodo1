package com.todo1.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.todo1.prueba.model.CarroCompras;
import com.todo1.prueba.service.CarroComprasService;

@Controller
public class CarroComprasController {

	@Autowired
	CarroComprasService service;
	
	@GetMapping(value = "/carrito")
	public String Carrito(Model model) {
		
		List<CarroCompras> lista = service.obtenerCarrito();
		
		model.addAttribute("listaCarrito", lista);
		
		return "pages/carrito";
	}
}
