package com.intertec.uservalidator.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.intertec.uservalidator.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	@Query("select u from User u where u.userName = ?1")
	User findUserByName(String userName);
	
}
