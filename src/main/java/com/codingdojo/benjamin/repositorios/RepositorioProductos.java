package com.codingdojo.benjamin.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.benjamin.modelos.Category;
import com.codingdojo.benjamin.modelos.Product;

@Repository
public interface RepositorioProductos extends CrudRepository<Product, Long> {

	List<Product> findAll();
	
	List<Product> findById(long id);
	
	List<Product> findByCategoriesNotContains(Category category);
}
