package com.reply.stream;

public class UserAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	UserAlreadyExistsException(String userName) {
		super("username: "+ userName+" already exists in system");
	}
}
