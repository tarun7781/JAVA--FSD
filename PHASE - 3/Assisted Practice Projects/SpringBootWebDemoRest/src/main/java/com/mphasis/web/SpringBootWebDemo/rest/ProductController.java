package com.mphasis.web.SpringBootWebDemo.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.web.SpringBootWebDemo.entity.Product;
import com.mphasis.web.SpringBootWebDemo.service.ProductService;

//for a class to be available as a web service
@RestController
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductService  service;
	
	@GetMapping("/products")
	public List<Product> getAllProducts()
	{
		return service.getAllProducts();
	}
	@GetMapping("/products/{pid}")
	public Product getProductById(@PathVariable int pid)
	{
		return service.getProductById(pid);
	}
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product)
	{
		
		if(this.service.insertProduct(product)!=-1)
			return product;
		return null;
	}
	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product product)
	{
		if(this.service.updateProduct(product))
			return product;
		return null;
	}
	@DeleteMapping("/products/{pid}")
	public String deleteProductById(@PathVariable int pid)
	{
		if(this.service.deleteProduct(pid))
		{
			return "deleted";
		}
		return "Could not delete";
	}
	
}









