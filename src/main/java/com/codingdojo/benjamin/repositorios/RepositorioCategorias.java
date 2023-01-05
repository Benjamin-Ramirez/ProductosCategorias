package com.codingdojo.benjamin.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.benjamin.modelos.Category;
import com.codingdojo.benjamin.modelos.Product;

@Repository
public interface RepositorioCategorias extends CrudRepository<Category, Long> {

	List<Category> findAll();
	
	List<Category> findById(long id);
	
	List<Category> findByProductsIdIsNull();
	
	Category findByName(String name);
	
	List<Category> findByProductsNotContains(Product product);
	
	
	
}
