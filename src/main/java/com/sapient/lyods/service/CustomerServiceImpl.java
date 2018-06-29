package com.sapient.lyods.service;

import org.springframework.stereotype.Service;

import com.sapient.lyods.model.Customer;
import com.sapient.lyods.util.CreditCardUtil;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Override
	public Customer createCustomer(String customerName) {
		int customerId = CreditCardUtil.genarateId();
		Customer customer = new Customer(customerId, customerName); 
		return customer;
	}
}
