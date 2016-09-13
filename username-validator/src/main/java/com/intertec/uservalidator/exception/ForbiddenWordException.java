package com.intertec.uservalidator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="Forbidden Word for Username Found")  // 403
public class ForbiddenWordException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6157848111639395087L;

	public ForbiddenWordException(String message) {
		super(message);
	}
}
