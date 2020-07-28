package com.springboot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.entity.Seller;
import com.springboot.demo.entity.User;
import com.springboot.demo.repository.ProductRepository;
import com.springboot.demo.repository.SellerRepository;
import com.springboot.demo.repository.UserRepository;

@Service

public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;
 

	public List<Seller> getSellers() {
		// System.out.println("ALL users!!")
		return sellerRepository.findAll();
	}
	
	
	public Seller saveMySeller(Seller seller) {
		return sellerRepository.save(seller);
	}
	
	
	
	
	
}
