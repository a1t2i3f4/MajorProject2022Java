package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modal.User;

public interface RegistrationRepository extends JpaRepository<User, Integer>{
	public User findByEmailId(String emailId);
	public User findByEmailIdAndPassword(String emailId, String password);

}
