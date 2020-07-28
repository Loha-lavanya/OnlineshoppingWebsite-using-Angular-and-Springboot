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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.entity.User;
import com.springboot.demo.repository.UserRepository;
import com.springboot.demo.service.UserService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	

	  /////////       GET ALL THE USERS        ////////
		@GetMapping("/getUsers")
		public  List<User> getAllUsers()
		{
			System.out.println("GET USERS!!");
			return userService.getUsers();
		}
		@GetMapping("/getUsers/detail")
		public  List<User> getUserDetail()
		{
			System.out.println("GET Detail!!");
			return userService.getUsers();
		}
	
		 /////////       GET USER BY ID        ////////
		
		@GetMapping("/users/{id}")
		public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
				throws ResourceNotFoundException
		{
		
			User user = userRepository.findById(userId)
					.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
			return ResponseEntity.ok().body(user);
		} 
		
		

        //////////////////CREATE NEW USER               /////////
         @PostMapping("/save-users")
          public User createUser(@Valid @RequestBody User user) {
          return userService.saveMyUser(user);
            } 

              ////////////////////////UPDATE USER    ////////
         @PutMapping("/user/{id}")
      public ResponseEntity<User> updateUsers(@PathVariable(value = "id") Long userId,@Valid @RequestBody User userDetails) 
		throws ResourceNotFoundException {
      User user = userRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

      user.setName(userDetails.getName());
      user.setUsername(userDetails.getUsername());
      user.setEmail(userDetails.getEmail());
      user.setPassword(userDetails.getPassword());
      User updatedUser = userService.saveMyUser(user);
         return ResponseEntity.ok(updatedUser);
}
         
         

     	////////////////// DELETE THE User ///////////
     	@DeleteMapping("/user/{id}")
     	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
     			throws ResourceNotFoundException {
     		User user =userRepository.findById(userId)
     				.orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + userId));

     		userRepository.delete(user);
     		Map<String, Boolean> response = new HashMap<>();
     		response.put("deleted", Boolean.TRUE);
     		return response;
     	}
		
}




