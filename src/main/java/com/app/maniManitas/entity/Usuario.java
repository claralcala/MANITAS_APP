package com.app.maniManitas.entity;



import org.hibernate.validator.constraints.URL;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

import org.hibernate.validator.*;

@Entity
public class Usuario extends DomainEntity{
	
	@NotBlank
	private String name;

	@Column(unique=true)
	private String username;
	
	@NotBlank
	private String surname;
	
	@NotBlank
	private String password;
	
	@URL
	private String urlPhoto;
	
	@Email
	private String email;
	
	@NotBlank
	private String address;
	
	@Column
	@OneToMany
	//con One To Many no se puede poner optional!
	private List<SocialProfile> socialProfiles;
	
	
	private Integer phone;
	
	@NotBlank
	
	private Rol rol;
	
	
	public Usuario(int id, int version, String username, String password, String urlPhoto, String email, String address,
			Rol rol) {
		super(id, version);
		this.username = username;
		this.password = password;
		this.urlPhoto = urlPhoto;
		this.email = email;
		this.address = address;
		this.rol = rol;
	}
	
	public Usuario() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrlPhoto() {
		return urlPhoto;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [username=" + username + ", password=" + password + ", urlPhoto=" + urlPhoto + ", email="
				+ email + ", address=" + address + ", rol=" + rol + "]";
	}
	
	
	
	
	
	
}
