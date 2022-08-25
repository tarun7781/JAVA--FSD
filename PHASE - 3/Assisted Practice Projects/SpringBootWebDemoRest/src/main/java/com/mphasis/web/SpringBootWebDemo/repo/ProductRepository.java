package com.mphasis.web.SpringBootWebDemo.repo;

import org.springframework.data.repository.CrudRepository;

import com.mphasis.web.SpringBootWebDemo.entity.Product;


//CrudRepository is an interface that takes care of all basic CRUD operations
// select by id, select all, delete. save or update, count
public interface ProductRepository 
extends CrudRepository<Product, Integer>{

}
