package com.capgemini.dao;

import java.util.Map;

import com.capgemini.bean.Customer;

public class CustomerDAOImpl {
	private Map<String, Customer> Customerdata; 
	public CustomerDAOImpl(Map<String, Customer> Customerdata) 
	{
		super();
		this.Customerdata = Customerdata;
	}

	public Customer save(Customer customer) 
	{
		if(Customerdata.containsKey(customer.getMobileNumber()))
		{
			Customerdata.replace(customer.getMobileNumber(), customer);
		}
		else
			Customerdata.put(customer.getMobileNumber(), customer);
	
		return customer;
		
	}

public Customer findByMobileNumber(String mobileNumber) {
		
		Customer customer=null;
		
		
		
		customer=Customerdata.get(mobileNumber);
		return customer;
		}

}
