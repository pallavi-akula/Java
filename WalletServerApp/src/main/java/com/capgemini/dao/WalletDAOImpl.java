package com.capgemini.dao;

import java.math.BigDecimal;
import java.util.Map;

import com.capgemini.bean.Customer;

public class WalletDAOImpl implements CustomerDAO {
	
	private Map<String,Customer> customerData;
	
	public WalletDAOImpl(Map<String, Customer> customerData) {
		super();
		this.customerData = customerData;
	}

	public Customer save(Customer customer) {
		if(customerData.containsKey(customer.getMobileNumber()))
		{
			customerData.replace(customer.getMobileNumber(),customer);
		}
		else
			customerData.put(customer.getMobileNumber(),customer);
		return customer;
	}

	public Customer findByMobileNumber(String mobileNumber) {
		Customer customer=null;
		
		customer=customerData.get(mobileNumber);
		return customer;
	}

	public Customer updateCustomerWalletBalance(String mobileNumber,BigDecimal amount) {
		return null;
	}

	



}
