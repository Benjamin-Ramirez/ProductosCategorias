package com.codingdojo.benjamin.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.benjamin.modelos.Category;
import com.codingdojo.benjamin.modelos.Product;
import com.codingdojo.benjamin.servicios.AppService;

@Controller
public class AppController {

	@Autowired
	private AppService service;
	
	
	
	// ------------------------------ GETS --------------------------
	
	
	@GetMapping("/products/new")
	public String product(@ModelAttribute("producto") Product producto) {
		return "newProduct.jsp";
	}
	@GetMapping("/categories/new")
	public String category(@ModelAttribute("categoria") Category categoria) {
		return "newCategory.jsp";
	}
	@GetMapping("products/{id}")
	public String producto(@PathVariable("id")Long id, Model model) {
		
		Product producto = service.findProduct_by_id(id);
		model.addAttribute("productos", producto);
		
		List<Category> categoria = service.findCategory_forProducts(producto);
		model.addAttribute("categorias", categoria);
		
		return "product.jsp";
	}
	@GetMapping("/categories/{id}")
	public String categoria(@PathVariable("id") Long id, Model model) {
		
		Category categoria = service.findCategory_by_id(id);
		model.addAttribute("categorias", categoria);
		
		List<Product> producto = service.findProduct_foraCtegory(categoria);
		model.addAttribute("productos", producto);
		
		return "category.jsp";
		
	}
	
	
	// ------------------------------ POSTS --------------------------
	
	
	@PostMapping("/create/category")
	public String create_catory(@Valid @ModelAttribute("categoria") Category categoria, BindingResult result) {
		
		if(result.hasErrors()) {
			return "newCategory.jsp";
		}else {
			service.save_category(categoria);
			return "redirect:/products/new";
		}
	}
	@PostMapping("/create/product")
	public String create_product(@Valid @ModelAttribute("producto") Product producto, BindingResult result) {
		
		if(result.hasErrors()) {
			return "newProduct.jsp";
		}else {
			service.save_product(producto);
			return "redirect:/categories/new";
		}
	}
	@PostMapping("/assign_category")
	public String assign_category(@RequestParam(value="category_id") Long category_id,
								  @RequestParam(value="product_id") Long product_id) {
		
		service.save_producto_categoria(product_id, category_id);
		return "redirect:/products/"+product_id;
	}
	@PostMapping("/assign_product")
	public String assign_product(@RequestParam(value="product_id") Long product_id,
								@RequestParam(value="category_id") Long category_id) {
		
		service.save_categoria_producto(product_id, category_id);
		return "redirect:/categories/"+category_id;
		
	}
	
	
	
	
	
}
