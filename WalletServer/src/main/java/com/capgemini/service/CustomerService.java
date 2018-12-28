package com.capgemini.service;

import java.math.BigDecimal;

import com.capgemini.bean.Customer;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InvalidInputException;

public interface CustomerService {
	
	public Customer createAccount(String customerName,String mobileNumber, BigDecimal balance) throws InsufficientBalanceException, InvalidInputException;
	public Customer fundTransfer(String sourceMobileNumber, String destinationMobileNumber, BigDecimal bigDecimal) throws InsufficientBalanceException, InvalidInputException;
	public Customer depositAmount(String mobileNumber, BigDecimal balance) throws InvalidInputException;
	public Customer showBalance(String mobileNumber) throws InvalidInputException;
	public Customer showTransactions(String mobileNumber);
	
	
	public boolean isValidCustomerName(String customerName) throws InvalidInputException;
	public boolean isValidMobileNumber(int mobileNumber) throws InvalidInputException;
	public boolean isValidBalance(BigDecimal balance) throws InvalidInputException;


}
