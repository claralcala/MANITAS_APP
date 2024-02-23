package com.app.maniManitas.entity;

import java.util.List;

import jakarta.persistence.OneToMany;

public class Customer extends Usuario{

	@OneToMany
	private List<Task> tasks;
	
}
