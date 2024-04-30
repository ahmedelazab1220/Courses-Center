package com.example.UniversityRestApi.exc;

public class InstructorNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InstructorNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public InstructorNotFoundException(String message) {
		super(message);
	}

	public InstructorNotFoundException(Throwable cause) {
		super(cause);
	}

}
