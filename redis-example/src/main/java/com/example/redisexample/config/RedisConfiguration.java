package com.example.redisexample.config;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration.JedisClientConfigurationBuilder;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories
public class RedisConfiguration {

//	@Value("${redis.host}")
//	private String host;
//
//	@Value("${redis.port}")
//	private int port;
//
//	@Value("${redis.database}")
//	private int database;
//
//	@Value("${redis.password}")
//	private String password;
//
//	@Value("${redis.timeout}")
//	private String timeout;
	@Bean
	public JedisConnectionFactory  jedisConnectionFactory() {
		String timeout= "6000";
		RedisStandaloneConfiguration redisConfiguration = new RedisStandaloneConfiguration();
		redisConfiguration.setHostName("localhost");
		redisConfiguration.setPort(6379);
//		redisConfiguration.setDatabase(database);
//		redisConfiguration.setPassword(RedisPassword.of(password));
		JedisClientConfigurationBuilder jedisClientConfiguration = JedisClientConfiguration.builder();
	    jedisClientConfiguration.connectTimeout(Duration.ofMillis(Long.parseLong(timeout)));
		return new JedisConnectionFactory(redisConfiguration);
	}
	//To access redis server from java code we need use redis template
	@Bean
	public RedisTemplate<String, Object> redisTemplate(){
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());
		template.setKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new JdkSerializationRedisSerializer());
		//template.setValueSerializer(new JdkSerializationRedisSerializer());
		//template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
		template.setEnableTransactionSupport(true);
		template.afterPropertiesSet();
		return template;
	}
}
