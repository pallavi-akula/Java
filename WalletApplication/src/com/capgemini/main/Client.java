package com.capgemini.main;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.capgemini.bean.Customer;
import com.capgemini.service.CustomerServiceImp;
import com.capgemini.service.ICustomerService;


public class Client {
	public static void main( String[] args )
	   {
		 CustomerServiceImp customerService;
			Map<String,Customer> data=new HashMap<String, Customer>();
		
			{
				System.out.println("Welcome to Payment Wallet Application");
				customerService=new CustomerServiceImp(data);
			}
			
		   
			String mobileNo;

			Customer customer ;

				        	Customer customer1=customerService.createAccount("pallavi","8885590001", new BigDecimal("900.00"));
				        	System.out.println("Account is created");
				        	Customer customer2=customerService.createAccount("priya","8885590002", new BigDecimal("5000.00"));
				        	System.out.println("Account is created");
				        	Customer customer3=customerService.createAccount("mahi","8885590003", new BigDecimal("700.00"));
				        	System.out.println("Account is created");
				        	Customer customer4=customerService.createAccount("valli","8885590004", new BigDecimal("500.00"));
				        	System.out.println("Account is created");
				        	Customer customer5=customerService.createAccount("krina","8885590005", new BigDecimal("400.00"));
				        	System.out.println("Account is created");


	customer=customerService.showBalance("8885590001");
	System.out.println("Your Current Balance is "+customer.getWallet().getBalance());
	customer=customerService.showBalance("8885590002");
	System.out.println("Your Current Balance is "+customer.getWallet().getBalance());
	customer=customerService.showBalance("8885590003");
	System.out.println("Your Current Balance is "+customer.getWallet().getBalance());
	customer=customerService.showBalance("8885590004");
	System.out.println("Your Current Balance is "+customer.getWallet().getBalance());
	customer=customerService.showBalance("8885590005");
	System.out.println("Your Current Balance is "+customer.getWallet().getBalance());
	   }
	}


