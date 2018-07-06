package com.jbilling;

/**
 * Created by rvaibhav on 08/11/17.
 */
public class InvalidInputException extends Exception {

	private String message;

	public InvalidInputException() {
		super();
	}

	public InvalidInputException(String message) {
		this.message = message;
	}

}
