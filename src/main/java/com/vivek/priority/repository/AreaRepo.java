package com.vivek.priority.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vivek.priority.model.Areas;

public interface AreaRepo extends MongoRepository<Areas, String> {

	
	
}
