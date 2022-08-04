package com.example.redisexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.redisexample.entity.Product;
import com.example.redisexample.service.ProductService;

@RestController
@RequestMapping("/rest/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	@GetMapping
	public List<Product> findAllProducts(){
		return productService.findAllProducts();
	}
	@GetMapping("/{id}")
	public Product findProductById(@PathVariable int id){
		return productService.findProductById(id);
	}
	@DeleteMapping("/{id}")
	public String deleteProductById(@PathVariable int id){
		return productService.deleteProductById(id);
	}
}
