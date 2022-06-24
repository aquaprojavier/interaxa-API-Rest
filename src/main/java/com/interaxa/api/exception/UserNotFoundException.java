package com.interaxa.api.exception;

public class UserNotFoundException extends Exception{

 static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
		super(message);
	}

}
