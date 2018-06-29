package com.sapient.lyods.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sapient.lyods.model.Account;
import com.sapient.lyods.model.CreditCard;
import com.sapient.lyods.model.Customer;
import com.sapient.lyods.util.CreditCardUtil;

//This needs to be Repository as of now i have made it as a Service
//since no database interaction
@Service
public class CreditCardRepository {

	public static Map<String, CreditCard> map = new HashMap<String, CreditCard>();

	/*public CreditCard getCreditCardById(String creditCardNumber) {
		return map.get(creditCardNumber);
	}*/

	public CreditCard findCreditCardById(String cardNumber) {
		return map.get(cardNumber);
	}

	public static Map<String, CreditCard> getMap() {
		return map;
	}

	public static void setMap(Map<String, CreditCard> map) {
		CreditCardRepository.map = map;
	}

	//Caching the Credit card details since not using the DB here
	static {
		Account account = new Account(1, "SavingsBank", 0.0);
		CreditCard creditCard = new CreditCard("378282246310005", 10000.00);
		creditCard.setExperidate(CreditCardUtil.addCalendar(1));
		creditCard.setAccount(account);
		account.setCreditCard(creditCard);
		Customer customer = new Customer(1, "Raghu");
		customer.getListAccount().add(account);
		account.setCustomer(customer);
		account.setCreditCard(creditCard);

		Account account1 = new Account(2, "SavingsBank", 0.0);
		CreditCard creditCard1 = new CreditCard("38520000023237", 10000.00);
		creditCard1.setExperidate(CreditCardUtil.addCalendar(1));
		creditCard1.setAccount(account1);
		account1.setCreditCard(creditCard1);
		Customer customer1 = new Customer(2, "llyods");
		customer1.getListAccount().add(account1);
		account1.setCustomer(customer1);
		account1.setCreditCard(creditCard1);

		Account account2 = new Account(3, "SavingsBank", 0.0);
		CreditCard creditCard2 = new CreditCard("4012888888881881", 10000.00);
		creditCard2.setExperidate(CreditCardUtil.addCalendar(1));
		creditCard2.setAccount(account2);
		account2.setCreditCard(creditCard2);
		Customer customer2 = new Customer(3, "Sapient");
		customer2.getListAccount().add(account2);
		account2.setCustomer(customer2);
		account2.setCreditCard(creditCard2);

		Account account3 = new Account(4, "SavingsBank", 0.0);
		CreditCard creditCard3 = new CreditCard("371449635398431", 10000.00);
		creditCard3.setExperidate(CreditCardUtil.addCalendar(1));
		creditCard3.setAccount(account3);
		account3.setCreditCard(creditCard3);
		Customer customer3 = new Customer(4, "Yadav");
		customer3.getListAccount().add(account3);
		account3.setCustomer(customer3);
		account3.setCreditCard(creditCard3);

		Account account4 = new Account(5, "SavingsBank", 0.0);
		CreditCard creditCard4 = new CreditCard("378734493671000", 10000.00);
		creditCard4.setExperidate(CreditCardUtil.addCalendar(1));
		creditCard4.setAccount(account4);
		account4.setCreditCard(creditCard4);
		Customer customer4 = new Customer(5, "Bharath");
		customer4.getListAccount().add(account4);
		account4.setCustomer(customer4);
		account4.setCreditCard(creditCard4);
		
		map.put(creditCard.getCardNumber(), creditCard);
		map.put(creditCard1.getCardNumber(), creditCard1);
		map.put(creditCard2.getCardNumber(), creditCard2);
		map.put(creditCard3.getCardNumber(), creditCard3);
		map.put(creditCard4.getCardNumber(), creditCard4);
		
	}

	//Storing in HashMap in Cache
	public CreditCard save(CreditCard creditCard) {
		map.put(creditCard.getCardNumber(), creditCard);
		return map.get(creditCard.getCardNumber());
	}

}
