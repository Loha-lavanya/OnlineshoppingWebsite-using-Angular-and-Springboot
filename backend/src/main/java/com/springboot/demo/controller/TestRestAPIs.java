package com.springboot.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TestRestAPIs {
	
 // @PreAuthorize to decide whether a method can actually be invoked or not:
 @GetMapping("/api/test/user")
 @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
 public String userAccess() {
   return ">>> User Contents!";
 }

 @GetMapping("/api/test/admin")
 @PreAuthorize("hasRole('ADMIN')")
 public String adminAccess() {
	 System.out.println("ADMIN");
   return ">>> Admin Contents";
 
 }

 
}