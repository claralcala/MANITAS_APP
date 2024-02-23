package com.app.maniManitas.entity;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;

public class Task extends DomainEntity{

	@NotBlank
	@Pattern(regexp = [0-9A-Z]{6})
	Column(unique = true)
	private String idTask;
	
	private Date dateTask;
	
	private String addressTask;
	
	private double priceMax;
	
	@ManyToOne
	private Category category;
	
}
