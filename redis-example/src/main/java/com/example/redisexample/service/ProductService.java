package com.example.redisexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.redisexample.entity.Product;
import com.example.redisexample.repository.ProductDao;
@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	public Product saveProduct(Product product) {
		return productDao.saveProduct(product);
	}

	public List<Product> findAllProducts() {
		return productDao.findAllProducts();
	}

	public Product findProductById(int id) {
		return productDao.findProductById(id);
	}
	
	public String deleteProductById(int id) {
		return productDao.deleteProductById(id);
	}

}
