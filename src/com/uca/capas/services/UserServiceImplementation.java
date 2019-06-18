package com.uca.capas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.User;
import com.uca.capas.repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public boolean login(String username, String password) {
		boolean response =  false;
		
		User dummyUser = userRepository.findOneByUsernameAndPassword(username, password);
		
		if(dummyUser != null) {
			response = true;
		}else {
			response = false; 
		}
		
		return response;
	}

}
