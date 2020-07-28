package com.springboot.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.entity.Seller;
import com.springboot.demo.repository.SellerRepository;
import com.springboot.demo.service.SellerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SellerController {

	@Autowired
	private SellerService sellerService;
	

	@Autowired
	private SellerRepository sellerRepository;
	  
	      /////////       GET ALL THE SELLERS        ////////
	@GetMapping("/getSellers")
	public List<Seller> getAllSellers() {
		return sellerService.getSellers();
	}
	
          /////////       GET SELLER BY ID        ////////
	
	@GetMapping("/sellers/{id}")
	public ResponseEntity<Seller> getSellerById(@PathVariable(value = "id") Long sellerId)
			throws ResourceNotFoundException {
	
		Seller seller = sellerRepository.findById(sellerId)
				.orElseThrow(() -> new ResourceNotFoundException("Seller not found for this id :: " + sellerId));
		return ResponseEntity.ok().body(seller);
	}
	
	
	       //////////////////     CREATE NEW SELLER                /////////
	@PostMapping("/save-sellers")
	public Seller createEmployee(@Valid @RequestBody Seller seller) {
		 return sellerService.saveMySeller(seller);
	} 
	
	
	          ////////////////////////     UPDATE SELLER     ////////
	@PutMapping("/sellers/{id}")
	public ResponseEntity<Seller> updateSellers(@PathVariable(value = "id") Long sellerId,
			@Valid @RequestBody Seller sellerDetails) throws ResourceNotFoundException {
		Seller seller = sellerRepository.findById(sellerId)
				.orElseThrow(() -> new ResourceNotFoundException("Seller not found for this id :: " + sellerId));

		seller.setEmailId(sellerDetails.getEmailId());
		seller.setLastName(sellerDetails.getLastName());
		seller.setFirstName(sellerDetails.getFirstName());
		 Seller updatedSeller = sellerService.saveMySeller(seller);
		return ResponseEntity.ok(updatedSeller);
	}
	
	
	      ////////////////// DELETE THE SELLER ///////////
	@DeleteMapping("/sellers/{id}")
	public Map<String, Boolean> deleteSeller(@PathVariable(value = "id") Long sellerId)
			throws ResourceNotFoundException {
		Seller seller = sellerRepository.findById(sellerId)
				.orElseThrow(() -> new ResourceNotFoundException("Seller not found for this id :: " + sellerId));

		sellerRepository.delete(seller);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
}
