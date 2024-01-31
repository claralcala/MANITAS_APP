package com.app.maniManitas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.maniManitas.entity.Category;
import com.app.maniManitas.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	
	public Category findByid(Integer id) {
		Category res = null;
		Optional <Category> cat= categoryRepository.findByid(id);
		
		if (cat.isPresent()) {
			res = cat.get();
		}
		
		return res;
		
	}
	
	
	public void deleteById(Integer id) {
		categoryRepository.deleteById(id);
	}
	
	
	

}
