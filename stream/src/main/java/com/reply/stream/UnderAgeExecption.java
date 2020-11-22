package com.reply.stream;

public class UnderAgeExecption extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	UnderAgeExecption() {
	    super("user should be at least 18 years old");
	  }
}
