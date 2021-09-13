package com.todo1.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo1.prueba.model.Usuario;
import com.todo1.prueba.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Usuario> obtenerUsuarios() {
		return usuarioRepository.findAll();
	}
	
	public Usuario insertarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
}
