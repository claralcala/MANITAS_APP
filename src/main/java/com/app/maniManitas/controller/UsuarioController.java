package com.app.maniManitas.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.maniManitas.entity.TokenUsuario;
import com.app.maniManitas.entity.Usuario;
import com.app.maniManitas.security.JWTGenerator;
import com.app.maniManitas.service.UsuarioService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/usuario")

public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Autowired
	private JWTGenerator jwtGenerator;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@PostMapping("/registro")
	public ResponseEntity <String> registro (@RequestBody Usuario u){
		
		if (usuarioService.findByUsername(u.getUsername()).isPresent()) {
			return new ResponseEntity<String>("El usuario ya existe", HttpStatus.BAD_REQUEST);
		}
		
		Usuario usuario = new Usuario();
		usuario.setUsername(u.getUsername());
		usuario.setAddress(u.getAddress());
		usuario.setEmail(u.getEmail());
		usuario.setPassword(passwordEncoder.encode(u.getPassword()));
		usuario.setUrlPhoto(u.getUrlPhoto());
		usuario.setRol(u.getRol());
		
		usuarioService.save(usuario);
		
		return new ResponseEntity<String>("Usuario creado correctamente", HttpStatus.OK);
		
		
		
		
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Usuario u ){
		Optional<Usuario> user = usuarioService.findByUsername(u.getUsername());
		
		if (user.isPresent() && user.get().getPassword().equals(passwordEncoder.encode(u.getPassword()))){
			
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(u.getUsername(), u.getPassword()));
			
			String token = jwtGenerator.generatorToken(authentication);
			
			return new ResponseEntity<String>(token, HttpStatus.OK);
			
		}else {
			return new ResponseEntity<String>("Login incorrecto", HttpStatus.BAD_REQUEST);
			
				
			
		}
		
	}
	
	
}
