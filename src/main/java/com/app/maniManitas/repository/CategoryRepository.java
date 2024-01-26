package com.app.maniManitas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.maniManitas.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{
	
	List<Category> findAll();
	
	
	

}
