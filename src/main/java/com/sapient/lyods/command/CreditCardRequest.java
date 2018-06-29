package com.sapient.lyods.command;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreditCardRequest {

	@NotNull(message = "Customer Name should not be empty")
	private String name;
	
	@NotNull(message = "Valid Card Number Needed")
	@Size(min=10,max=20)
	private String cardNumber;
	
	@NotNull(message="credit Limit info missing in the request")
	private double creditLimit;

	public CreditCardRequest() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
}
