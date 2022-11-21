package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.User;
import com.example.demo.service.RegistrationService;

@RestController
@CrossOrigin
public class RegistrationController {
	@Autowired
	private RegistrationService service;
	
	@PostMapping("/registeruser")
	public ResponseEntity<?> registerUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId(); 
		
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			User userobj = service.fetchUserByEmailId(tempEmailId);
			if(userobj != null) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User with "+tempEmailId+" already Exists");
			}
		}
			
		User userObj = null;
		userObj = service.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userObj);
		
	}
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		String tempPass = user.getPassword();
		User userObj = null;
		if(tempEmailId != null && tempPass != null) {
			userObj = service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
			
		}
		if(userObj == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Bad Credentials");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(userObj);
	}

}
