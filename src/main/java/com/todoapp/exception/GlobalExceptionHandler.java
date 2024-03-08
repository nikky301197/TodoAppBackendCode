package com.todoapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	ResponseEntity<ApiErrorResponse> resourceNotFoundException(ResourceNotFoundException ex) {
		String msg = ex.getMessage();
		String error = "Resource Not Found Exception";
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;

		ApiErrorResponse apierr = new ApiErrorResponse(error, msg, httpStatus);

		return new ResponseEntity<ApiErrorResponse>(apierr, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ResourceAlreadyExistException.class)
	ResponseEntity<ApiErrorResponse> resourceAlreadyExistException(ResourceAlreadyExistException ex) {
		String msg = ex.getMessage();
		String error = "Resource Already Exist Exception";
		HttpStatus httpStatus = HttpStatus.CONFLICT;

		ApiErrorResponse apierr = new ApiErrorResponse(error, msg, httpStatus);

		return new ResponseEntity<ApiErrorResponse>(apierr, HttpStatus.NOT_FOUND);
	}
	
	
}
