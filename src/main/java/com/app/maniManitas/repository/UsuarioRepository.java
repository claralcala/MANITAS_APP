package com.app.maniManitas.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.app.maniManitas.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	
	Optional<Usuario> findByUsername(String username);

}
