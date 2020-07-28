package com.springboot.demo.controller;


import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.entity.CartItem;
import com.springboot.demo.entity.Order;
import com.springboot.demo.entity.Seller;
import com.springboot.demo.entity.User;
import com.springboot.demo.repository.OrderRepository;
import com.springboot.demo.repository.UserRepository;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class OrderController {
	@Autowired
	 private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository; 
	
	@GetMapping("/orders")
	  public List<Order> getOrders()
	  {
		return orderRepository.findAll();
      }
	@GetMapping("/orderUser/{username}")
	public List<Order> getOrderByUserId(@PathVariable(value = "username") String username)
	{
		System.out.println("your order");
		Optional<User> user=userRepository.findByUsername(username);	
		   User u=user.get();
		
		Long orderId=userRepository.findByUsername(username).get().getId();
		   System.out.println(orderId);
		List<Order> order =orderRepository.findByUserId(orderId);
		return order;
	}
}

