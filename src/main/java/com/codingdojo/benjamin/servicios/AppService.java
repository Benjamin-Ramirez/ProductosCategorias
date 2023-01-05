package com.codingdojo.benjamin.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.benjamin.modelos.Category;
import com.codingdojo.benjamin.modelos.Product;
import com.codingdojo.benjamin.repositorios.RepositorioCategorias;
import com.codingdojo.benjamin.repositorios.RepositorioProductos;

@Service
public class AppService {

	@Autowired
	private RepositorioProductos repositorio_productos;
	@Autowired
	private RepositorioCategorias repositorio_categorias;
	
	
	
	// ----------------- PRODUCTOS ------------------------
	
	public List<Product> find_all_products(){
		return repositorio_productos.findAll();
	}
	public Product findProduct_by_id(Long id) {
		
		Optional<Product> optionalProduct = repositorio_productos.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		else {
			return null;
		}
	}
	public Product save_product(Product product) {
		return repositorio_productos.save(product);
	}
	public List<Product> findProduct_foraCtegory(Category category){
		return repositorio_productos.findByCategoriesNotContains(category);
	}
	
	
	// ----------------- CATEGORIAS------------------------
	
	public List<Category> find_all_categories(){
		return repositorio_categorias.findAll();
	}
	public Category findCategory_by_id(Long id) {
		
		return repositorio_categorias.findById(id).orElse(null);
		
	}
	public Category save_category(Category category) {
		return repositorio_categorias.save(category);
	}
	public Category find_category(String texto) {
		return repositorio_categorias.findByName(texto);
	}
	public List<Category> findCategory_forProducts(Product product){
		return repositorio_categorias.findByProductsNotContains(product);
	}
	public List<Category> findCategory_nullId(){
		return repositorio_categorias.findByProductsIdIsNull();
	}
	
	
	
	// --------------- PRODUCTOS Y CATEGORIAS --------------
	
	public void save_producto_categoria(Long product_id, Long category_id) {
		
		Product producto = findProduct_by_id(product_id);
		Category categoria = findCategory_by_id(category_id);
		
		List<Category> lista_categorias = producto.getCategories();
		
		lista_categorias.add(categoria);
		
		producto.setCategories(lista_categorias);
		
		repositorio_productos.save(producto);
		
	}
	public void save_categoria_producto(Long product_id, Long category_id) {
		
		Category categoria = findCategory_by_id(category_id);
		Product producto = findProduct_by_id(product_id);
		
		List<Product> lista_productos = categoria.getProducts();
		
		lista_productos.add(producto);
		
		categoria.setProducts(lista_productos);
		
		repositorio_categorias.save(categoria);
		
		
	}
	
	
	

	
}
