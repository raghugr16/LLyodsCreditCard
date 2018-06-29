package com.sapient.lyods.service;

import java.util.List;

import com.sapient.lyods.command.ChargeCreditRequest;
import com.sapient.lyods.command.CreditCardRequest;
import com.sapient.lyods.model.CreditCard;

public interface CreditCardService {

	public CreditCard addCreditCard(CreditCardRequest creditCardRequest);
	public CreditCard chargeRequest(ChargeCreditRequest chargeRequest);
	public CreditCard creditRequest(ChargeCreditRequest chargeRequest);
	public List<CreditCard> getAllCreditCard();
	public boolean validate(CreditCard creditCard);
}
