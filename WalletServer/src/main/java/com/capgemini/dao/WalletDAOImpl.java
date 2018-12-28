package com.capgemini.dao;

import java.math.BigDecimal;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.capgemini.bean.Customer;
@Repository
public class WalletDAOImpl implements CustomerDAO {
	
	public void setCustomerData(Map<String, Customer> customerData) {
		this.customerData = customerData;
	}

	public WalletDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Resource(name="map")
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
