package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modal.Product;
import com.example.demo.repo.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;

	public ProductService() {}

	public Product getProductById(Long id) {
		try {
			Product product = this.repo.findById(id).get();
			return product;
		}catch(Exception e) {
			return null;
		}
	}

	public List<Product> getProducts() {return (List<Product>) this.repo.findAll();}
	
	public List<Product> getProductCategory(String ProductCategory) {return (List<Product>) this.repo.findByProductCategory(ProductCategory);}

	public Product createProduct(Product product) {
		this.repo.save(product);
		return product;
	}

	public void updateProduct(Long eId, Product emp) {
		try {
			Product product = repo.findById(eId).get();
			product.setProductName(emp.getProductName());
			product.setProductCategory(emp.getProductCategory());
			product.setProductRate(emp.getProductRate());
			product.setDescription(emp.getDescription());
			product.setRating(emp.getRating());
			product.setImageurl(emp.getImageurl());
			

			
			repo.save(product);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void deleteProduct(Long id) {
		try {
			Product product = this.repo.findById(id).get();
			this.repo.delete(product);
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		
	}
}
