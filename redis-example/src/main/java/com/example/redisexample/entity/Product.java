package com.example.redisexample.entity;
import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// store as hash in redis so below annotation
@RedisHash("Product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String name;
	private int qty;
	private long price;
	
}