package com.todo1.prueba.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.todo1.prueba.model.Usuario;

public class SecurityUser implements UserDetails {

	private Usuario usuario;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public SecurityUser(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Integer getUserId() {
		return this.usuario.getId();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
		authorities.add(authority);
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String claveEncriptada = bCryptPasswordEncoder.encode(this.usuario.getPassword());
		return claveEncriptada;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return usuario.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return usuario.getActive();
	}

}
