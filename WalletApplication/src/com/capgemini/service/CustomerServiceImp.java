package com.capgemini.service;

import java.math.BigDecimal;

import java.util.Map;

import com.capgemini.bean.Customer;
import com.capgemini.bean.Wallet;
import com.capgemini.dao.CustomerDAOImpl;
import com.capgemini.exception.InvalidInputException;


public class CustomerServiceImp implements ICustomerService  {
	private CustomerDAOImpl customerdao;
	private CustomerDAOImpl dao;
	public CustomerServiceImp(Map<String, Customer> data){
		dao= new CustomerDAOImpl(data);
	}
	public CustomerServiceImp(CustomerDAOImpl dao) 
	{
		super();
		this.dao = dao;
	}

	
	public Customer createAccount(String customerName,String mobileNumber, BigDecimal balance)
	{
		Customer customer=null;
		
		if(isValidName(customerName) && isValidMobile(mobileNumber) && isValidamount(balance))
		{
		customer=new Customer(customerName,mobileNumber,new Wallet(balance));
		if(dao.findByMobileNumber(mobileNumber) != null)
			throw new InvalidInputException("The account with mobile Number "+ mobileNumber+" is already created");
		dao.save(customer);
		}
		
		return customer;
	}
	
	
	
	public Customer showBalance(String mobileNumber) throws InvalidInputException
	{
		Customer customer=null;
		if(isValidMobile(mobileNumber))
		{
		  customer=dao.findByMobileNumber(mobileNumber);
		}
		if(customer == null)
			throw new InvalidInputException("The mobile Number You Entered is Not having Payment Wallet Account");
		return customer;}
	public Customer showTransactions(int mobileNumber)
	{
		return null;}

public boolean isValidName(String customerName) throws InvalidInputException 
{
	if( customerName == null)
		throw new InvalidInputException( "Sorry, Customer Name is null" );
	
	if( customerName.trim().isEmpty() )
		throw new InvalidInputException( "Sorry, customer Name is Empty" );
	
	return true;
}

public boolean isValidMobile(String mobileNumber)throws InvalidInputException
{
	if( mobileNumber == null ||  isPhoneNumberInvalid( mobileNumber ))
		throw new InvalidInputException( "Sorry, Phone Number "+mobileNumber+" is invalid"  );
	
	return true;
}

public boolean isValidamount(BigDecimal amount)throws InvalidInputException
{
	if( amount == null || isAmountInvalid( amount ) )
		throw new InvalidInputException( "Amount is invalid" );

	return true;
}

public boolean isAmountInvalid(BigDecimal amount) 
{
	
	if( amount.compareTo(new BigDecimal(0)) < 0) 
	{
		return true;
	}		
	else 
		return false;
}

public static boolean isPhoneNumberInvalid( String phoneNumber )
{
	if(String.valueOf(phoneNumber).matches("[1-9][0-9]{9}")) 
	{
		return false;
	}		
	else 
		return true;
}

	
}

