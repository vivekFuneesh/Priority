package com.vivek.priority.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vivek.priority.model.User;

public interface UserRepo extends MongoRepository<User, String>{

	public User findByName(String name);
	
}
