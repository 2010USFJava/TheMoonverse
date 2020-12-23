package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.repos.UserRepository;

import com.revature.exception.ResourceNotFoundException;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		
		return userRepo.findAll();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@GetMapping("/users/{user_id}")
	public ResponseEntity<User> getPostById(@PathVariable(value = "user_id") int userId)
			throws ResourceNotFoundException {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Post Not Found For This Id :: " + userId));
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User user) {
		return userRepo.save(user);
	}
	
	@PutMapping("/users/{user_id}")
	public ResponseEntity<User> updatePost(@PathVariable(value = "user_id") int userId,
			@Valid @RequestBody User userDetails) throws ResourceNotFoundException {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Post Not Found For This Id :: " + userId));
		
		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setBirthDate(userDetails.getBirthDate());
		
		final User updatedUser = userRepo.save(user);
		return ResponseEntity.ok(updatedUser);
	}
}
