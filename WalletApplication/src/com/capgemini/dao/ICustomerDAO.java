package com.capgemini.dao;

import com.capgemini.bean.Customer;

public interface ICustomerDAO {
	public boolean save(Customer customer);

	Customer findByMobileNumber(String mobileNumber);

	//Customer updateCustomerWalletBalance(int mobileNumber,BigDecimal amount);

	

}
