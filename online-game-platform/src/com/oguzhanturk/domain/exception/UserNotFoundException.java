package com.oguzhanturk.domain.exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException() {
		super("Please check user!");
	}

	public UserNotFoundException(String message) {
		super(message);
	}

}
