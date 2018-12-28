package com.capgemini.service;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.bean.Customer;
import com.capgemini.bean.Wallet;
import com.capgemini.dao.CustomerDAO;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InvalidInputException;

public class CustomerServiceImpl implements CustomerService{
	
	private CustomerDAO customerDAO;

	/*public CustomerServiceImpl(Map<String, Customer> customerData) {
		customerDAO= new WalletDAOImpl(customerData);
	}*/

	public CustomerServiceImpl(CustomerDAO customerDAO) {
		super();
		this.customerDAO = customerDAO;
	}

	public Customer createAccount(String customerName, String mobileNumber, BigDecimal balance)
			throws InsufficientBalanceException, InvalidInputException {
		
		Customer customer=null;
		
		if(isValidCustomerName(customerName) && isValidMobileNumber(mobileNumber) && isValidBalance(balance))
		{
			customer=new Customer(customerName,mobileNumber,new Wallet(balance));
			if(customerDAO.findByMobileNumber(mobileNumber) != null)
				throw new InvalidInputException("The account with mobile Number "+ mobileNumber+" is already created");
			customerDAO.save(customer);
		}

		return customer;
	}
	
	public Customer fundTransfer(String sourceMobileNumber, String destinationMobileNumber) {
		return null;
	}
	public Customer depositAmount(String mobileNumber, BigDecimal balance) {
		return null;
	}
	public Customer showBalance(String mobileNumber) throws InvalidInputException {
		Customer customer=null;
		if(isValidMobileNumber(mobileNumber))
		{
			customer=customerDAO.findByMobileNumber(mobileNumber);
		}
		if(customer == null)
			throw new InvalidInputException("The mobile Number You Entered is Not having Payment Wallet Account");
		return customer;
	}
	public Customer showTransactions(String mobileNumber) {
		return null;
	}

	
	
	
	
	

	public boolean isValidCustomerName(String customerName) throws InvalidInputException 
	{
		if( customerName == null)
			throw new InvalidInputException( "Sorry, Customer Name is null" );

		if( customerName.trim().isEmpty() )
			throw new InvalidInputException( "Sorry, customer Name is Empty" );
		Pattern p = Pattern.compile("[A-Z]{1}[a-z]{3,10}");
		Matcher m = p.matcher(customerName);
		if(m.matches()){
			return true;
		}
		else{
			throw new InvalidInputException("Enter Valid Name \n Name should start with Capital letter");
		}
		/*return true;*/
	}

	public boolean isValidMobileNumber(String mobileNumber)throws InvalidInputException
	{
		if( mobileNumber == null ||  isMobileNumberInvalid( mobileNumber ))
			throw new InvalidInputException( "Sorry, Phone Number "+mobileNumber+" is invalid"  );

		return true;
	}

	public boolean isValidBalance(BigDecimal balance)throws InvalidInputException
	{
		if( balance == null || isAmountInvalid( balance ) )
			throw new InvalidInputException( "Amount is invalid" );

		return true;
	}

	public boolean isAmountInvalid(BigDecimal balance) 
	{

		if( balance.compareTo(new BigDecimal(0)) < 0) 
		{
			return true;
		}		
		else 
			return false;
	}

	public static boolean isMobileNumberInvalid(String mobileNumber )
	{
		if(String.valueOf(mobileNumber).matches("^[1-9]{1}[0-9]{9}$")) 
		{
			return false;
		}		
		else 
			return true;
	}

	
}