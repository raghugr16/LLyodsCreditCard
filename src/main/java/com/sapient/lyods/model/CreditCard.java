package com.sapient.lyods.model;

import java.util.Date;

public class CreditCard {

	private String cardNumber;
	private double creditLimit;
	private Account account;
	private Date experidate;

	public CreditCard(String cardNumber, double creditLimit) {
		super();
		this.cardNumber = cardNumber;
		this.creditLimit = creditLimit;
	}

	public CreditCard() {

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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Date getExperidate() {
		return experidate;
	}

	public void setExperidate(Date experidate) {
		this.experidate = experidate;
	}

}
