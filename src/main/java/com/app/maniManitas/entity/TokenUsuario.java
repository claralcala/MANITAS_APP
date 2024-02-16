
package com.app.maniManitas.entity;

public class TokenUsuario {
	
	private String token;
	private String tipo = "Bearer ";
	
	
	public TokenUsuario() {
		
	}
	
	
	public TokenUsuario(String token, String tipo) {
		super();
		this.token = token;
		this.tipo = tipo;
	}


	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
