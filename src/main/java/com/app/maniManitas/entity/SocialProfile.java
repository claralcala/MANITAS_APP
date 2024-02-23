package com.app.maniManitas.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

@Entity
public class SocialProfile extends DomainEntity{
	
	@NotBlank
	private String nickName;
	
	

}
