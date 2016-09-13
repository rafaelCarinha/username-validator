package com.intertec.uservalidator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intertec.uservalidator.service.UserService;

@RestController
public class UserController {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user", method = RequestMethod.POST, consumes = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<?> save(@RequestBody String username) {
		try {
			LOG.info("Username Post");
			userService.saveUser(username);
		} catch(RuntimeException ex) {
			LOG.warn(ex.getMessage(), ex);
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN); 
		} catch(Exception ex) {
			LOG.error(ex.getMessage(), ex);
			return new ResponseEntity<>("Unexpected Error", HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
