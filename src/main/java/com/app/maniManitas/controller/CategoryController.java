
package com.app.maniManitas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.maniManitas.entity.Category;
import com.app.maniManitas.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("")
	public List<Category> findAll(){
		return categoryService.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Category findByid(@PathVariable Integer id) {
		return categoryService.findByid(id);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Integer id) {
		categoryService.deleteById(id);
		
	}

}
