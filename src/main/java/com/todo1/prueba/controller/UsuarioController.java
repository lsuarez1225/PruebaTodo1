package com.todo1.prueba.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.todo1.prueba.model.Usuario;
import com.todo1.prueba.service.UsuarioService;
import com.todo1.prueba.utils.AjaxResponse;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioService servicio;
	
	@GetMapping(value = "/usuarios")
	public String usuarios(Model model) {
		
		List<Usuario> lista = servicio.obtenerUsuarios();
		model.addAttribute("listaUsuarios", lista);
		
		return "pages/usuarios";
	}
	
	@PostMapping(value = "/usuario")
	public ResponseEntity<Object> crearUsuario(@RequestBody Usuario usuario, Errors errors) {
		
		AjaxResponse response = new AjaxResponse();
		
		if (errors.hasErrors()) {
			response.setStatus(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
			return ResponseEntity.badRequest().body(response);
		}
		
		
		usuario.setActive(true);
		usuario.setEntereddate(LocalDate.now());
		
		Usuario usuarioInsertado = servicio.insertarUsuario(usuario);
		
		response.setStatus("OK");
		response.setObject(usuarioInsertado);
		
		return ResponseEntity.ok(response);
	}
}
