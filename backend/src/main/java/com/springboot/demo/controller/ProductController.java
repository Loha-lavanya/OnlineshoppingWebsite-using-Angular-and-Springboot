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
import com.springboot.demo.service.ProductService;
import com.springboot.demo.entity.Product;
import com.springboot.demo.repository.ProductRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@Autowired
	private ProductRepository productRepository;
	

	           //    GET ALL THE PRODUCT   
		@GetMapping("/products/getProducts")
		public  List<Product> getAllProducts()
		{
			System.out.println("GET USERS!!");
			return productService.getProducts();
		}
		
	
		//      GET PRODUCT BY ID        
		
		@GetMapping("/products/{id}")
		public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long productId)
				throws ResourceNotFoundException
		{
		
			Product product = productRepository.findById(productId)
					.orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: " + productId));
			return ResponseEntity.ok().body(product);
		} 
		
		

        //CREATE NEW PRODUCT          
       @PostMapping("/products/save")
        public Product createProduct(@Valid @RequestBody Product product) {
        return productService.saveMyProduct(product);
          } 

            //UPDATE PRODUCT  
       @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateUsers(@PathVariable(value = "id") Long productId,@Valid @RequestBody Product productDetails) 
		throws ResourceNotFoundException {
    	   Product product = productRepository.findById(productId)
      .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + productId));

    product.setSku(productDetails.getSku());
    product.setName(productDetails.getName());
    product.setDescription(productDetails.getDescription());
    product.setUnitPrice(productDetails.getUnitPrice());
    product.setImageUrl(productDetails.getImageUrl());
    product.setActive(productDetails.isActive());
    product.setUnitsInStock(productDetails.getUnitsInStock());
    product.setDateCreated(productDetails.getDateCreated());
    product.setLastUpdated(productDetails.getLastUpdated());
    
    product.setCategory(productDetails.getCategory());
    

    Product updatedProduct = productService.saveMyProduct(product);
       return ResponseEntity.ok(updatedProduct);
}
       
       

   	// DELETE THE PRODUCT
   	@DeleteMapping("/products/{id}")
   	public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long productId)
   			throws ResourceNotFoundException {
   		Product product =productRepository.findById(productId)
   				.orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: " + productId));

   		productRepository.delete(product);
   		Map<String, Boolean> response = new HashMap<>();
   		response.put("deleted", Boolean.TRUE);
   		return response;
   	}
	
}
