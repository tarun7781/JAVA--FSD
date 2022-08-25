package com.mphasis.web.SpringBootWebDemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.web.SpringBootWebDemo.entity.Product;
import com.mphasis.web.SpringBootWebDemo.repo.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;

	public long count()
	{
		// returns no of records
		return this.repo.count();
	}
	public int insertProduct(Product product)
	{
		if(this.repo.existsById(product.getPid()))
		{
			return -1;
		}
		// update or insert and save returns the saved entity
		// since my id is auto generated, i need that id
		Product savedProduct = this.repo.save(product);
		return savedProduct.getPid();
	}
	public boolean updateProduct(Product product)
	{
		if(!this.repo.existsById(product.getPid()))
		{
			return false;
		}
		this.repo.save(product);
		return true;
	}
	public Product getProductById(int pid)
	{
		return this.repo.findById(pid)
				.orElseThrow(() -> 
				new EntityNotFoundException("Product with "+pid+" does not exist"));
	}
	public List<Product> getAllProducts()
	{
		List<Product> products = new ArrayList<Product>();
		this.repo.findAll().forEach(product-> products.add(product));
		return products;
	}
	public boolean deleteProduct(int pid)
	{
		if(this.repo.existsById(pid))
		{
			this.repo.deleteById(pid);
			return true;
		}
		return false;
	}
}
