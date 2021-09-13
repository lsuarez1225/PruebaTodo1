package com.todo1.prueba.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.todo1.prueba.model.Usuario;
import com.todo1.prueba.repository.UsuarioRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repository.findByUsername(username);
		usuario.orElseThrow(() -> new UsernameNotFoundException("No se encontró usuario:"+username));
		return usuario.map(SecurityUser::new).get();
	}

}
