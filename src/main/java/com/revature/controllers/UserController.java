package com.revature.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.exception.ResourceNotFoundException;
import com.revature.repos.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/user")
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		 this.userRepository.findAll().forEach(users::add);
		 return users;
		
	}
	@ResponseStatus(HttpStatus.CREATED)
	@GetMapping("/user/{userId}")
	public Optional<User> getUserById(@PathVariable(value = "id") Integer userID)
		{Optional<User> user = userRepository.findById(userID);
		return user;
		}
	
	@PostMapping("/add")
	public User createUser ( @RequestBody User user) {
		return userRepository.save(user);
		//ToDO log new user created
		
}
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value="id")int userId, @RequestBody User userDetails)
		throws ResourceNotFoundException{
				User user = userRepository.findById(userId)
						.orElseThrow(() -> new ResourceNotFoundException("User not found for this id::" + userId));
				
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());
		final User updatedUser = userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}
		
		@DeleteMapping("/user/{id}")
	   public Map<String, Boolean> updateUser(@PathVariable(value="id")int userId )
		throws ResourceNotFoundException{
			User user = userRepository.findById(userId)
					.orElseThrow(() -> new ResourceNotFoundException("User not found for this id::" + userId));
			
		
		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return response;
	}

}

