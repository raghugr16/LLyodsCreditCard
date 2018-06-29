package com.sapient.lyods.handler;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.sapient.lyods.exceptions.CreditCardNotFoundException;
import com.sapient.lyods.exceptions.InvalidCreditCardException;
import com.sapient.lyods.exceptions.ResourceExistsException;
import com.sapient.lyods.model.RestErrorInfo;

public class AbstractRestHandler implements ApplicationEventPublisherAware{
	protected ApplicationEventPublisher eventPublisher;

	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.eventPublisher = applicationEventPublisher;
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(CreditCardNotFoundException.class)
	public @ResponseBody RestErrorInfo handleCreditCardNotFoundException(ResourceExistsException ex, WebRequest request,
			HttpServletResponse response) {
		return new RestErrorInfo(ex,"Credit Card Account not Found");
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(InvalidCreditCardException.class)
	public @ResponseBody RestErrorInfo handleInvalidCreditCardException(ResourceExistsException ex, WebRequest request,
			HttpServletResponse response) {
		return new RestErrorInfo(ex,"Invalid Card Number");
	}
	
/*	public static <T> T checkResourceFound(final T resource) {
		if (resource == null) {
			throw new ResourceNotFoundException("resource not found", null);
		}
		return resource;
	}
	
	public static <T> T checkNotResourceFound(final T resource) {
		if (resource != null) {
			throw new ResourceExistsException("resource  found");
		}
		return resource;
	}
*/
}
