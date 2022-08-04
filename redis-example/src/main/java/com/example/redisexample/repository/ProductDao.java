package com.example.redisexample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.redisexample.entity.Product;

@Repository
public class ProductDao {

	private static final String HASH_KEY = "Product";
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	public Product saveProduct(Product product) {
		redisTemplate.opsForHash().put(HASH_KEY, product.getId(), (Object) product);
		return product;
	}
	
	public Product updateProduct(Product product) {
		redisTemplate.opsForHash().put(HASH_KEY, product.getId(), (Object) product);
		return product;
	}
	
	public List<Product> findAllProducts(){
		return redisTemplate.opsForHash().values(HASH_KEY);
	}
	
	public Product findProductById(int id){
		return (Product) redisTemplate.opsForHash().get(HASH_KEY,id);
	}
	
	public String deleteProductById(int id){
		redisTemplate.opsForHash().delete(HASH_KEY,id);
		return "Product removed";
	}
}
