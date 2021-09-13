package com.todo1.prueba.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.todo1.prueba.excepcion.RegistroNoEncontrado;
import com.todo1.prueba.model.CarroCompras;
import com.todo1.prueba.model.Producto;
import com.todo1.prueba.model.Usuario;
import com.todo1.prueba.security.SecurityUser;
import com.todo1.prueba.service.CarroComprasService;
import com.todo1.prueba.service.ProductoService;
import com.todo1.prueba.utils.AjaxResponse;

@Controller
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@Autowired
	CarroComprasService carroComprasService;
	
	@GetMapping(value = "/home")
	public String home(Model model) {
		
		List<Producto> lista = productoService.obtenerProductos();
		model.addAttribute("listaProductos", lista);
		
		return "pages/home";
	}
	
	@PostMapping(value = "/agregarProducto")
	public ResponseEntity<Object> agregarProductoACarrito(@RequestBody CarroCompras carroCompras, Errors errors) throws RegistroNoEncontrado {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		SecurityUser usuario = (SecurityUser)auth.getPrincipal();
		
		carroCompras.setUserid(usuario.getUserId());
		
		AjaxResponse ajaxResponse = new AjaxResponse(); 
		
		if (errors.hasErrors()) {
			ajaxResponse.setStatus(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
			return ResponseEntity.badRequest().body(ajaxResponse);
		}
		
		CarroCompras carrito = carroComprasService.agregarProducto(carroCompras);

		ajaxResponse.setStatus("OK");
		ajaxResponse.setObject(carrito);
		
		return ResponseEntity.ok(ajaxResponse);
	}
}
