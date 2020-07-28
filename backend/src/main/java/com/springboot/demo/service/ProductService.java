package com.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.demo.entity.Product;
import com.springboot.demo.entity.User;
import com.springboot.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository repo;
	
	public List<Product> getProducts() {
		return repo.findAll();
	}

	public Product saveMyProduct(Product product) {
		repo.save(product);
		return product;
	}

	public Optional<Product> findByProductId(Long productId) {
		return repo.findById(productId);
	}
}
 