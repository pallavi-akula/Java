package com.capgemini.ui;

import com.capgemini.exception.InvalidInputException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import com.capgemini.bean.Customer;
import com.capgemini.dao.CustomerDAO;
import com.capgemini.dao.WalletDAOImpl;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.service.CustomerService;
import com.capgemini.service.CustomerServiceImpl;

public class Client {
	
    public static void main(String[] args) throws InsufficientBalanceException, InvalidInputException {
    	Map<String,Customer>customerdata = new HashMap<String,Customer>();
    	CustomerDAO customerdao = new WalletDAOImpl(customerdata);
    	CustomerService customerService = new CustomerServiceImpl(customerdao);
    	
    	Customer customer;
    	
    	
		customerService.createAccount("Himanshu","9876500000",new BigDecimal(5000.00));
		System.out.println("Account is created");
		customerService.createAccount("Ankit","9123456789",new BigDecimal(4000.00));
		System.out.println("Account is created");
		customerService.createAccount("Deepansh","9874563210",new BigDecimal(3500.00));
		System.out.println("Account is created");
		
		
		customer = customerService.showBalance("9876500000");
		System.out.println("Balance= " + customer.getWallet().getBalance() );
		customer = customerService.showBalance("9123456789");
		System.out.println("Balance= " + customer.getWallet().getBalance() );
		customer = customerService.showBalance("9874563210");
		System.out.println("Balance= " + customer.getWallet().getBalance() );
		
	
    }
}