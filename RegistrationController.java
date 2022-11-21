package com.cybage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.user;
import com.cybage.service.RegistrationService;


@RestController
@CrossOrigin
public class RegistrationController {

	@Autowired
	RegistrationService service;
	
	@PostMapping("/userRegister")
	public user registerUser(@RequestBody user user) throws Exception {
		// check whether user already in database or not
		 String tempEmailId=user.getEmailId();
		  if(tempEmailId !=null && !"".equals(tempEmailId)) {
			  // make method in service for check it in database
			 user userObj=  service.fetchUserByEmailId(tempEmailId);
			 
			 if(userObj!=null) {
				 throw new Exception("user with"+tempEmailId+"is already register");
			 }
		  }
		user userObj=null;
		userObj=service.saveUser(user);
		return userObj;
	}
	@PostMapping("/login")
	public user loginUser(@RequestBody user user) throws Exception {
		String tempEmailId=user.getEmailId();
		String tempPass=user.getPassword();
		//create user object to return the value
		user userObj=null;
		if(tempEmailId!=null&&tempPass!=null) {
			userObj=service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
		}
		 try {
			if(userObj  == null){
			    throw new Exception("Bad Request");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block//1hr 10min
			e.printStackTrace();
		}
		return userObj;
	}
}
