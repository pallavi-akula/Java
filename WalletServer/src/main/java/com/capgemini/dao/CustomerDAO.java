package com.capgemini.dao;

import java.math.BigDecimal;

import com.capgemini.bean.Customer;

public interface CustomerDAO {

	
	Customer save(Customer customer);

	Customer findByMobileNumber(String mobileNumber);

	Customer updateCustomerWalletBalance(String mobileNumber,BigDecimal amount);

	
}
