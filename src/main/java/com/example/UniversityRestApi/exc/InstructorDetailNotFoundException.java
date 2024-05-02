package com.example.UniversityRestApi.exc;

@SuppressWarnings("serial")
public class InstructorDetailNotFoundException extends RuntimeException {
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
