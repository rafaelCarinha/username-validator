package com.intertec.uservalidator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="Username already exists")  // 403
public class UsernameAlreadyExistsException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6157848111639395087L;
	
	public UsernameAlreadyExistsException(String message) {
		super(message);
	}

}
