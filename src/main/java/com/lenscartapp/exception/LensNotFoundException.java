package com.lenscartapp.exception;

public class LensNotFoundException extends RuntimeException {

	/**
	 * @author SumanD
	 *
	 */
	private static final long serialVersionUID = 1L;

	public LensNotFoundException() {
		super();
	}

	public LensNotFoundException(String message) {
		super(message);
	}

}
