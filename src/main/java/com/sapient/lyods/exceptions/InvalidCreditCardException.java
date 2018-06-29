package com.sapient.lyods.exceptions;

public class InvalidCreditCardException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7866428643870706534L;
	
	public InvalidCreditCardException() {
	}
	
	public InvalidCreditCardException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidCreditCardException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidCreditCardException(String message) {
		super(message);
	}

	public InvalidCreditCardException(Throwable cause) {
		super(cause);
	}

}
