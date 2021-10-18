package com.lenscartapp.exception;

public class CategoryNotFoundException extends RuntimeException {

	/**
	 * @author SumanD
	 *
	 */
	private static final long serialVersionUID = 1L;

	public CategoryNotFoundException() {
		super();
	}

	public CategoryNotFoundException(String message) {
		super(message);
	}

}
