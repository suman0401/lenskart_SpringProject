package com.lenscartapp.exception;

public class FrameNotFoundException extends RuntimeException {

	/**
	 * @author SumanD
	 *
	 */
	private static final long serialVersionUID = 1L;

	public FrameNotFoundException() {
		super();
	}

	public FrameNotFoundException(String message) {
		super(message);
	}

}
