package com.app.maniManitas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.RequestMethod;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	//Este metodo va a encargarse de verificar la informacion de los usuarios que se loguean en la API
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	//Para encriptar la contraseña del usuario
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//Establece una cadena de filtros en la API, además determina los roles de los usuarios para acceder a ciertas url
	@Bean
	SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
		
		http
			.csrf().disable()
			.authorizeHttpRequests() //Peticiones http deben estar permitidas
			.requestMatchers("/usuario/**").permitAll() //todas las url de usuario
			.requestMatchers(HttpMethod.POST, "/category/**").hasAnyAuthority("ADMIN")
			.requestMatchers(HttpMethod.GET, "/category/**").hasAnyAuthority("ADMIN")
			.and()
			.httpBasic();
		
		return http.build();
	}
}
