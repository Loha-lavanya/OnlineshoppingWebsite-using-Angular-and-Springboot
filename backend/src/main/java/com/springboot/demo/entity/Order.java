package com.springboot.demo.entity;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="order_product")
public class Order {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="id")
	    private int id;
	 
	 @Column(name = "user_id")
	 private Long userId;
		
	 @Column(name = "price")
     private  Double price;
     
     @Column(name = "order_on")
     @CreationTimestamp
     private Date orderOn;
    
     public Order()
     {
     }
  
     public Order(Long userId, Double price, int quantity) {
		super();
		this.userId = userId;
		this.price = price;
		this.quantity = quantity;
	}


	private int quantity;


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Date getOrderOn() {
		return orderOn;
	}


	public void setOrderOn(Date orderOn) {
		this.orderOn = orderOn;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}