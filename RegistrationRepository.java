package com.cybage.repo;

import org.springframework.data.repository.CrudRepository;

import com.cybage.model.user;



public interface RegistrationRepository extends CrudRepository<user, Long>{

	public user findByEmailId(String emailId);
	public user findByEmailIdAndPassword(String emailId,String password);
}
