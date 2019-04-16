package fr.formation.students.controllers;

import java.time.LocalDateTime;
import java.util.List;

public class ApiErrors {
	
	private LocalDateTime timestamp;
	
	private int httpCode;
	private String httpMessage;
	private int totalErrors;
	
	private List<ValidationError> errors;
	
	public ApiErrors() {
		// TODO Auto-generated constructor stub
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public int getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}

	public String getHttpMessage() {
		return httpMessage;
	}

	public void setHttpMessage(String httpMessage) {
		this.httpMessage = httpMessage;
	}

	public int getTotalErrors() {
		return totalErrors;
	}

	public void setTotalErrors(int totalErrors) {
		this.totalErrors = totalErrors;
	}
	
	
	public List<ValidationError> getErrors() {
		return errors;
	}
	
	public void setErrors(List<ValidationError> errors) {
		this.errors = errors;
	}
	
}
