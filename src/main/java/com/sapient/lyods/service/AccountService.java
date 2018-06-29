package com.sapient.lyods.service;

import com.sapient.lyods.model.Account;
import com.sapient.lyods.model.CreditCard;

public interface AccountService {
	public Account createAccount(CreditCard creditCard);
}
