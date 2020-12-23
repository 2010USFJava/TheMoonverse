package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.repos.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository =userRepository;
	}
	
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		 this.userRepository.findAll().forEach(users::add);
		 return users;
		 }

}
