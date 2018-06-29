package com.sapient.lyods.model;

public class Account {

	Integer accoountId;
	String accountType;
	double balance;

	CreditCard creditCard;

	Customer customer;

	public Account(Integer accoountId, String accountType, double balance) {
		super();
		this.accoountId = accoountId;
		this.accountType = accountType;
		this.balance = balance;
	}

	public Account() {

	}

	public Integer getAccoountId() {
		return accoountId;
	}

	public void setAccoountId(Integer accoountId) {
		this.accoountId = accoountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
