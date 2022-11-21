package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.Product;
import com.example.demo.service.ProductService;

@RestController 
@CrossOrigin
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable Long id) {
		return service.getProductById(id);
	}

	@GetMapping("/product")
	public List<Product> getProducts() {
		return service.getProducts();
	}
	
	@GetMapping("/products/{productCategory}")
	public ResponseEntity<?> getProductCategory(@PathVariable("productCategory") String ProductCategory ) {
		System.out.print("id  "+ProductCategory);
		String message = "";
		if(service.getProductCategory(ProductCategory).size() == 0) {
			message = "No Category Present";
			return new ResponseEntity<>(message,HttpStatus.NOT_FOUND); 
		} 
		return new ResponseEntity<>(service.getProductCategory(ProductCategory),HttpStatus.OK); 
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createProduct(@RequestBody Product emp) {
		service.createProduct(emp);
		return new ResponseEntity<>("Product Added Successfully",HttpStatus.CREATED); 
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
		service.deleteProduct(id);
		return new ResponseEntity<>("Product Deleted Successfully",HttpStatus.OK); 
	}
	
	 
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable Long id,@RequestBody Product emp) {
		service.updateProduct(id, emp);
		return new ResponseEntity<>("Product Updated Successfully",HttpStatus.NO_CONTENT);
		
	}
	
	@PatchMapping("/update/{id}")
	public ResponseEntity<?> updatePartialyProduct(@PathVariable Long id,@RequestBody Product emp) {
		service.updateProduct(id, emp);
		return new ResponseEntity<>("Product Updated Successfully",HttpStatus.NO_CONTENT); 
	}
	
}
