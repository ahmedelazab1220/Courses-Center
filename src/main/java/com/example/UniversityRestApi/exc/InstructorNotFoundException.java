package com.example.UniversityRestApi.exc;

@SuppressWarnings("serial")
public class InstructorNotFoundException extends RuntimeException {
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
