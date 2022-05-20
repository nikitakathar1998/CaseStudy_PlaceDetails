package com.capg.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobelExceptionHandler {

	@Value(value="${data.exception.msg}")
	
	private String msg;
	@ExceptionHandler(value = DataAlreadyExistsException.class)
	public ResponseEntity<String> DataAlreadyExistsException(DataAlreadyExistsException data)
	{
		return new ResponseEntity<String>(msg, HttpStatus.CONFLICT);
	}
	
	@Value(value="${data.exception.msg1}")
	
	private String msg1;
	@ExceptionHandler(value = DataAlreadyExistsException.class)
	public ResponseEntity<String> DataAlreadyDeletedException(DataAlreadyDeletedException data)
	{
		return new ResponseEntity<String>(msg1, HttpStatus.CONFLICT);
	}
}
