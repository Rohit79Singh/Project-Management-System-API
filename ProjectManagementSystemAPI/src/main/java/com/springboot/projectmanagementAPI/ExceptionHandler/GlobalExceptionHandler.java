package com.springboot.projectmanagementAPI.ExceptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public ResponseEntity<ApiError> handleValidationErrors(MethodArgumentNotValidException ex) {
	        ApiError error = new ApiError(HttpStatus.BAD_REQUEST, "Validation Error", ex.getBindingResult().getFieldErrors());
	        error.setValidationErrors(ex.getBindingResult().getFieldErrors());
	        return ResponseEntity.badRequest().body(error);
	    }

	    
	    @ExceptionHandler(Exception.class)
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    public ResponseEntity<ApiError> handleOtherExceptions(Exception ex) {
	        ApiError error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", null);
	        error.setMessage(ex.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	    }

	    
}