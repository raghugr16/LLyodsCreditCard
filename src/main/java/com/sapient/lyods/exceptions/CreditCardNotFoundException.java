package com.sapient.lyods.exceptions;

public class CreditCardNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7292415106176566808L;
	
	public CreditCardNotFoundException() {
	}
	
	public CreditCardNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CreditCardNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CreditCardNotFoundException(String message) {
		super(message);
	}

	public CreditCardNotFoundException(Throwable cause) {
		super(cause);
	}
}
