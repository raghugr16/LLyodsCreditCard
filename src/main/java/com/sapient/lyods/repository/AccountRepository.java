package com.sapient.lyods.repository;

import com.sapient.lyods.model.Account;
import com.sapient.lyods.model.CreditCard;

public class AccountRepository {

	public Account save(Account account){
		//I am using Map as a cache here instead of DB so 
		// doing crud operation on Map 
		CreditCard creditCard = CreditCardRepository.map.get(account);
		creditCard.setAccount(account);
		return creditCard.getAccount();
	}
}
