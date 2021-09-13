package com.todo1.prueba.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todo1.prueba.model.Usuario; 

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query(value = "FROM Usuario WHERE username = :username")
	Optional<Usuario> findByUsername(String username);
}
