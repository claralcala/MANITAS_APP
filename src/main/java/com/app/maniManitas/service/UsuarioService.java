package com.app.maniManitas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.maniManitas.entity.Category;
import com.app.maniManitas.entity.Usuario;
import com.app.maniManitas.repository.CategoryRepository;
import com.app.maniManitas.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	
	public Optional<Usuario> findByUsername(String username) {
		return this.usuarioRepository.findByUsername(username);
		
	}
	
	
	public void save(Usuario u) {
		this.usuarioRepository.save(u);
	}
	
	
	
	
	
	

}
