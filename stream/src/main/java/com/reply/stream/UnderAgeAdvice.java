package com.reply.stream;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class UnderAgeAdvice {
	@ResponseBody
	@ExceptionHandler(UnderAgeExecption.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	String employeeNotFoundHandler(UnderAgeExecption ex) {
		return ex.getMessage();
	}
	
	
	
}
