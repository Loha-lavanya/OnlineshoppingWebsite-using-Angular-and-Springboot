package com.springboot.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="cart")
@Embeddable
public class CartItem {
    
	

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	 @OneToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name = "product_id", nullable = false)
	 private Product product;
	 
	 @Column(name = "name")
	 private String name;
	 
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "image_url")
	private String imageUrl;
	 
	@Column(name = "unit_price")
	private double unitPrice;
	
	
	@Column(name = "username")
	private String  username;


	public CartItem()
	{
	
	}


	public CartItem(Product product, String name, int quantity, String imageUrl, double unitPrice, String username) {
		super();
		this.product = product;
		this.name = name;
		this.quantity = quantity;
		this.imageUrl = imageUrl;
		this.unitPrice = unitPrice;
		this.username = username;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	
}