package com.example.UniversityRestApi.exc;

public class InstructorDetailNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InstructorDetailNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public InstructorDetailNotFoundException(String message) {
		super(message);
	}

	public InstructorDetailNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
