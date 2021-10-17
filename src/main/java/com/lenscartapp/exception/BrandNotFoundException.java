package com.lenscartapp.exception;

public class BrandNotFoundException extends RuntimeException {

	/**
	 * @author SumanD
	 *
	 */
	private static final long serialVersionUID = 1L;

	public BrandNotFoundException() {
		super();
	}

	public BrandNotFoundException(String message) {
		super(message);
	}

}
