package com.sapient.lyods.service;

import org.springframework.stereotype.Service;

import com.sapient.lyods.model.CreditCard;
import com.sapient.lyods.util.CreditCardUtil;


@Service
public class CreditCartValidator {

	boolean validateCreditCard(CreditCard creditCard){
		return CreditCardUtil.checkCreditCardLuhn(creditCard.getCardNumber().toString());
	}

	public boolean validateCreditCard(String creditCardNumber) {
		return CreditCardUtil.checkCreditCardLuhn(creditCardNumber);
	}
}
