package com.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.repository.ProductRepository;
import com.springboot.demo.repository.UserRepository;
import com.springboot.demo.entity.Product;
import com.springboot.demo.entity.User;
@Service

public class UserService {

@Autowired
private UserRepository userRepo;


	public List<User> getUsers() {
		// System.out.println("ALL users!!")
		return userRepo.findAll();
	}

	public User saveMyUser(User user) {
		userRepo.save(user);
		return user;
	}
	
}