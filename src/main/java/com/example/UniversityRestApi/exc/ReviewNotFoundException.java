package com.example.UniversityRestApi.exc;

@SuppressWarnings("serial")
public class ReviewNotFoundException extends RuntimeException {

	public ReviewNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ReviewNotFoundException(String message) {
		super(message);
	}

	public ReviewNotFoundException(Throwable cause) {
		super(cause);
	}

}
