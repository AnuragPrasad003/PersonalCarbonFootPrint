package com.anupd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anupd.entity.User;
import com.anupd.repository.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	public String register(User user) {
		
		userRepository.save(user);
		return "Registered Successfully"; //HTTP success message
	}
	
	public User login(String email, String password) {
	    User user = userRepository.findByEmail(email);
	    if (user != null && user.getPassword().equals(password)) {
	        return user;
	    }
	    return null;
	}


}
