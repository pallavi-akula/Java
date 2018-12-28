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
	
	public Customer fundTransfer(String sourceMobileNumber, String destinationMobileNumber, BigDecimal balance) throws InsufficientBalanceException,InvalidInputException {
		Customer source=null;
		Customer target=null;
		if(isValidMobileNumber(sourceMobileNumber) && isValidMobileNumber(destinationMobileNumber) && isValidBalance(balance))
		{
			if(sourceMobileNumber.equals(destinationMobileNumber))
				throw new  InvalidInputException("Enter Different Accounts to transfer Money");

			if(balance.compareTo(new BigDecimal(0)) == 0 )
				throw new InvalidInputException("Enter valid Amount to transfer");
			source=customerDAO.findByMobileNumber(sourceMobileNumber);

			if(source == null)
				throw new InvalidInputException("There is No Payment wallet account for the Number "+sourceMobileNumber);

			target=customerDAO.findByMobileNumber(destinationMobileNumber);

			if(target == null)
				throw new InvalidInputException("There is No Payment wallet account for the Number "+destinationMobileNumber);

			if(balance.compareTo(source.getWallet().getBalance()) > 0 )
				throw new InsufficientBalanceException("Insufficient Balance in the account "+sourceMobileNumber);
			

			source=withdrawAmount(sourceMobileNumber, balance);
			target=depositAmount(destinationMobileNumber, balance);
			customerDAO.save(source);
			customerDAO.save(target);
		}
		return source;
	}
	private Customer withdrawAmount(String sourceMobileNumber, BigDecimal balance) throws InvalidInputException, InsufficientBalanceException {
		
		Customer customer=null;
		if(isValidMobileNumber(sourceMobileNumber) && isValidBalance(balance))
		{
			if(balance.equals(new BigDecimal(0)))
				throw new InvalidInputException("Enter Valid Amount to Withdraw");

			customer=customerDAO.findByMobileNumber(sourceMobileNumber);

			if(customer == null)
				throw new InvalidInputException("There is No Payment wallet account for the Number "+sourceMobileNumber);

			if(balance.compareTo(customer.getWallet().getBalance()) > 0 )
				throw new InsufficientBalanceException("Insufficient Balance");

			BigDecimal amount=customer.getWallet().getBalance().subtract(balance);
			customer.setWallet(new Wallet(amount));
			customerDAO.save(customer);
		}
		return customer;
	}

	public Customer depositAmount(String mobileNumber, BigDecimal balance) throws InvalidInputException {

		Customer customer=null;
		if(isValidMobileNumber(mobileNumber) && isValidBalance(balance))
		{
			customer=customerDAO.findByMobileNumber(mobileNumber);

			if(customer == null)
				throw new InvalidInputException("There is No Payment wallet account for the Number"+mobileNumber);

			if(balance.equals(new BigDecimal(0)))
				throw new InvalidInputException("Enter Valid Amount to Withdraw");

			BigDecimal amount=customer.getWallet().getBalance().add(balance);
			customer.setWallet(new Wallet(amount));
			customerDAO.save(customer);
		}

		return customer;
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

	public Customer fundTransfer(String sourceMobileNumber, String destinationMobileNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isValidMobileNumber(int mobileNumber) throws InvalidInputException {
		// TODO Auto-generated method stub
		return false;
	}

	
}