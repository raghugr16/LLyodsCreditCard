package com.sapient.lyods.exceptions;

public class ResourceExistsException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceExistsException() {
        super();
    }

    public ResourceExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceExistsException(String message) {
        super(message);
    }

    public ResourceExistsException(Throwable cause) {
        super(cause);
    }

}
