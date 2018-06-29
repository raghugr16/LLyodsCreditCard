package com.sapient.lyods.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.lyods.command.ChargeCreditRequest;
import com.sapient.lyods.command.CreditCardRequest;
import com.sapient.lyods.exceptions.CreditCardNotFoundException;
import com.sapient.lyods.exceptions.InvalidCreditCardException;
import com.sapient.lyods.model.Account;
import com.sapient.lyods.model.CreditCard;
import com.sapient.lyods.model.Customer;
import com.sapient.lyods.repository.CreditCardRepository;
import com.sapient.lyods.util.CreditCardUtil;

@Service
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
	CreditCartValidator creditCartValidator;

	@Autowired
	AccountService accountService;

	@Autowired
	CustomerService customerService;

	@Autowired
	CreditCardRepository creditCardRepository;

	@Override
	public CreditCard addCreditCard(CreditCardRequest creditCardRequest) {
		CreditCard creditCard = findCreditCardById(creditCardRequest.getCardNumber());
		Account account = null;
		if (creditCard == null) {
			account = accountService.createAccount(creditCard);
			creditCard = new CreditCard(creditCardRequest.getCardNumber(), creditCardRequest.getCreditLimit());
			creditCard.setExperidate(CreditCardUtil.addCalendar(10));
			creditCard.setAccount(account);
			Customer customer = customerService.createCustomer(creditCardRequest.getName());
			customer.getListAccount().add(account);
			account.setCustomer(customer);
			account.setCreditCard(creditCard);
			creditCard = creditCardRepository.save(creditCard);
		}
		return creditCard;
	}

	private CreditCard findCreditCardById(String cardNumber) {

		return creditCardRepository.findCreditCardById(cardNumber);
	}

	@Override
	public CreditCard chargeRequest(ChargeCreditRequest chargeRequest) {
		CreditCard creditCard = this.findCreditCard(chargeRequest.getCreditCardNumber());
		if (creditCard != null) {
			Account account = creditCard.getAccount();
			double debitBalance = account.getBalance() + Double.valueOf(chargeRequest.getAmount());
			account.setBalance(debitBalance);
			creditCardRepository.save(creditCard);
		} else {
			throw new CreditCardNotFoundException(chargeRequest.getCreditCardNumber() + " not Found");
		}
		return creditCard;
	}

	private CreditCard findCreditCard(String creditCardNumber) {
		CreditCard creditCard = null;
		if (creditCartValidator.validateCreditCard(creditCardNumber)) {
			creditCard = creditCardRepository.findCreditCardById(creditCardNumber);
		} else {
			throw new InvalidCreditCardException(
					"Invalid Credit Card Number " + CreditCardUtil.getLastFourDigitAccountNumber(creditCardNumber));
		}
		return creditCard;
	}

	@Override
	public CreditCard creditRequest(ChargeCreditRequest chargeRequest) {
		CreditCard creditCard = this.findCreditCard(chargeRequest.getCreditCardNumber());
		if (creditCard != null) {
			Account account = creditCard.getAccount();
			double debitBalance = account.getBalance() - Double.valueOf(chargeRequest.getAmount());
			account.setBalance(debitBalance);
			creditCardRepository.save(creditCard);
		} else {
			throw new CreditCardNotFoundException(chargeRequest.getCreditCardNumber() + " not Found");
		}
		return creditCard;
	}

	@Override
	public List<CreditCard> getAllCreditCard() {
		Map<String, CreditCard> map = creditCardRepository.getMap();
		List<CreditCard> lCreditCards = new ArrayList<CreditCard>();
		for (Map.Entry<String, CreditCard> entry : map.entrySet()) {
			lCreditCards.add(entry.getValue());
		}
		return lCreditCards;
	}

	@Override
	public boolean validate(CreditCard creditCard) {
		return creditCartValidator.validateCreditCard(creditCard);
	}

}
