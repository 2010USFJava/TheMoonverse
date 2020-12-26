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

import com.revature.exception.ResourceNotFoundException;
import com.revature.beans.Users;
import com.revature.repos.UsersRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class UsersController {

	@Autowired
	private UsersRepository userRepo;
	
	@GetMapping("/users")
	public List<Users> getAllUsers() {
		
		return userRepo.findAll();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@GetMapping("/users/{user_id}")
	public ResponseEntity<Users> getUserById(@PathVariable(value = "user_id") int userId)
			throws ResourceNotFoundException {
		Users user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Not Found For This Id :: " + userId));
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping("/adduser")
	public Users createUser(@Valid @RequestBody Users user) {
		return userRepo.save(user);
	}
	
	@PutMapping("/users/{user_id}")
	public ResponseEntity<Users> updateUser(@PathVariable(value = "user_id") int userId,
			@Valid @RequestBody Users userDetails) throws ResourceNotFoundException {
		Users user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Not Found For This Id :: " + userId));
		
		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setBirthDate(userDetails.getBirthDate());
		
		final Users updatedUser = userRepo.save(user);
		return ResponseEntity.ok(updatedUser);
	}
}
