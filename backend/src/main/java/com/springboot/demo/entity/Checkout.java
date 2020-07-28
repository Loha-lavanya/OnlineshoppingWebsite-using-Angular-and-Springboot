package com.springboot.demo.entity;

public class Checkout {

	
	 private String firstname;
	 private String lastname;
	 private String email;
	 private String country;
	 private String street;
	 private String city;
	 private String state;
	 public Checkout()
	 {
	 }
	 public Checkout(String firstname, String lastname, String email, String country, String street, String city,
			String state, Long zipcode) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.country = country;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	private Long zipcode;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getZipcode() {
		return zipcode;
	}
	public void setZipcode(Long zipcode) {
		this.zipcode = zipcode;
	}

}
