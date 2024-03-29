package com.app.maniManitas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.maniManitas.entity.Category;
import com.app.maniManitas.entity.Usuario;
import com.app.maniManitas.repository.CategoryRepository;
import com.app.maniManitas.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	
	public Optional<Usuario> findByUsername(String username) {
		return this.usuarioRepository.findByUsername(username);
		
	}
	
	
	public void save(Usuario u) {
		this.usuarioRepository.save(u);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		
		Optional<Usuario> usuario = usuarioRepository.findByUsername(username);
		
		if(usuario.isEmpty()) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
		Usuario u = usuario.get();
		List<GrantedAuthority> autoridades = new ArrayList<GrantedAuthority>(); 
		autoridades.add(new SimpleGrantedAuthority(u.getRol().toString()));
		
		return new User(u.getUsername(), u.getPassword(), autoridades);
	}
	
	
	
	
	
	

}
