package com.mphasis.web.SpringBootWebDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mphasis.web.SpringBootWebDemo.entity.Product;
import com.mphasis.web.SpringBootWebDemo.service.ProductService;

/**
 * 1) dispatcher servlet
 * 2) view resolver
 * 3) tomcat
 */
@SpringBootApplication
public class SpringBootWebDemoApplication {
/*
 * 1) pom.xml dependencies
 * 2) webapp folder and folders and files within
 * 3) application.properties
 * 4) HomeController
 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebDemoApplication.class, args);
	}

	@Autowired
	private ProductService service;
	
	@Bean
	public void products()
	{
		this.service.insertProduct(new Product(1, "Pencil", "Used for writing", 30));
		this.service.insertProduct(new Product(2, "Laptop", "Apple MAC", 800000));
		this.service.insertProduct(new Product(3, "Speaker", "Sony HD", 30000));
	}
}
