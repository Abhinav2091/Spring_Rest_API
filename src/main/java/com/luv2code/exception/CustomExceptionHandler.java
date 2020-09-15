package com.luv2code.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //for global exception
public class CustomExceptionHandler {

	// added Exception handler for Any Exception
		@ExceptionHandler
		public ResponseEntity<Object> handleException(Exception notFound) {

			// create a Student Error
			ErrorResponse error = new ErrorResponse();
			error.setStatus(HttpStatus.BAD_REQUEST.value());
			error.setMessage("Global Excpetion:"+notFound.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}

}
