package com.springboot.demo.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.entity.CartItem;
import com.springboot.demo.entity.Order;
import com.springboot.demo.entity.User;
import com.springboot.demo.repository.CartItemRepository;
import com.springboot.demo.repository.OrderRepository;
import com.springboot.demo.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CartItemController {
	@Autowired
	 private UserRepository userRepository;
	

    @Autowired
	 private OrderRepository orderRepository;
    
	 @Autowired
 	 private CartItemRepository cartItemRepository;
	@PostMapping("/cart")
	public String addOrder(@RequestBody ArrayList<CartItem> products)
	{
		System.out.println("Cart added succesfully!!");
		String username="";
		double  total=0;
		int size=0;
		for(CartItem cart:products) 
		{
			total+=cart.getUnitPrice();
			size+=cart.getQuantity();
			username=cart.getUsername();
	 	 cartItemRepository.save(cart);
		}
		
		 System.out.println(username);
		   Optional<User> user=userRepository.findByUsername(username);	
		   User u=user.get();
		   
        Order order=new Order(u.getId(),total,size);
        orderRepository.save(order);
		return "items added in cart";
	}
	
}
