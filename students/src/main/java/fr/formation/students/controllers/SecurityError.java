package fr.formation.students.controllers;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class SecurityError implements Serializable {

    private final int status;

    private final String message;

    private SecurityError(int status, String message) {
	this.status = status;
	this.message = message;
    }

    public int getStatus() {
	return status;
    }

    public String getMessage() {
	return message;
    }

    public static SecurityError of(HttpStatus status, String message) {
	return new SecurityError(status.value(), message);
    }
}
