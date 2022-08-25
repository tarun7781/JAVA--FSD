package com.mphasis.web.SpringBootWebDemo.rest;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionHandler {

	@ExceptionHandler(value = EntityNotFoundException.class)
	public ResponseEntity<Object> handleExeption(EntityNotFoundException e)
	{
		return new ResponseEntity<Object>("Product Not Found", HttpStatus.NOT_FOUND);
	}
}

