package com.sapient.lyods.service;

import org.springframework.stereotype.Service;

import com.sapient.lyods.model.Account;
import com.sapient.lyods.model.CreditCard;
import com.sapient.lyods.util.CreditCardUtil;

@Service
public class AccountServiceImpl implements AccountService{

	@Override
	public Account createAccount(CreditCard creditCard) {
			Integer accountId = CreditCardUtil.genarateId();
			Account account = new Account(accountId, "SavingAccount", 0.0);
			return account;
	}

	
}
