package com.intertec.uservalidator.repository;

import org.springframework.data.repository.CrudRepository;

import com.intertec.uservalidator.model.ForbiddenWord;

public interface ForbiddenWordRepository extends CrudRepository<ForbiddenWord, Long> {
	
}
