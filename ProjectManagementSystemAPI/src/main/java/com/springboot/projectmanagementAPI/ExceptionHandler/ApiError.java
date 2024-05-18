package com.springboot.projectmanagementAPI.ExceptionHandler;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

public class ApiError {

	private HttpStatus status;
    private String message;
    private List<FieldError> validationErrors;
    
	public ApiError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiError(HttpStatus status, String message, List<FieldError> list) {
		super();
		this.status = status;
		this.message = message;
		this.validationErrors = list;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<FieldError> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(List<FieldError> validationErrors) {
		this.validationErrors = validationErrors;
	}

	@Override
	public String toString() {
		return "ApiError [status=" + status + ", message=" + message + ", validationErrors=" + validationErrors + "]";
	}
  
  	
	
}