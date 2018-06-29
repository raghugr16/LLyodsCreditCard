package com.sapient.lyods.command;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ChargeCreditRequest {

	@NotNull(message = "Valid Card Number Needed")
	@Size(min=10,max=20)
	private String creditCardNumber;
	
	
	@NotNull(message = "Amount is missing")
	private String amount;

	public ChargeCreditRequest(String creditCardNumber, String amount) {
		this.creditCardNumber = creditCardNumber;
		this.amount = amount;
	}

	public ChargeCreditRequest() {
	}



	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
