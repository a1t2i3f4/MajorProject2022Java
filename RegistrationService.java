package com.cybage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.user;
import com.cybage.repo.RegistrationRepository;


@Service
public class RegistrationService {
 
	@Autowired
	private RegistrationRepository repo;
	
	public user saveUser(user user) {
		return repo.save(user);
	}
	
	public user fetchUserByEmailId(String email) {
		
	//if inbuilt method is not there define it in service by creating that method
		 return repo.findByEmailId(email);
	}
	public user fetchUserByEmailIdAndPassword(String email,String password) {
		return repo.findByEmailIdAndPassword(email, password);
				//declare this method in repo findbyemailandPassword
	}

	
}
