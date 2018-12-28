package com.capgemini.ui;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.capgemini.AppConfig;
import com.capgemini.bean.Customer;
import com.capgemini.dao.CustomerDAO;
import com.capgemini.dao.WalletDAOImpl;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InvalidInputException;
import com.capgemini.service.CustomerService;
import com.capgemini.service.CustomerServiceImpl;



public class Client {
	
    public static void main(String[] args) throws InsufficientBalanceException, InvalidInputException {
  
    	Map<String,Customer>customerdata = new HashMap<String,Customer>();
		CustomerDAO customerdao = new WalletDAOImpl(customerdata);
		CustomerService customerService = new CustomerServiceImpl(customerdao);

		Customer customer;
		
	/*//GenericXmlApplicationContext ctx= new GenericXmlApplicationContext("beanconfig.xml");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    	CustomerService customerService= ctx.getBean("s",CustomerServiceImpl.class); 
    	Customer customer;*/
    	
    	
		customerService.createAccount("Pallavi","9876500000",new BigDecimal(7000.00));
		System.out.println("Account is created");
		customerService.createAccount("Kiran","9123456789",new BigDecimal(4000.00));
		System.out.println("Account is created");
		customerService.createAccount("Prabha","9874563210",new BigDecimal(3500.00));
		System.out.println("Account is created");
		
		customer = customerService.showBalance("9876500000");
		System.out.println("Balance= " + customer.getWallet().getBalance() );
		customer = customerService.showBalance("9123456789");
		System.out.println("Balance= " + customer.getWallet().getBalance() );
		customer = customerService.showBalance("9874563210");
		System.out.println("Balance= " + customer.getWallet().getBalance() );
		System.out.println("\n\n");
		
		

		System.out.println("Fund Transfer:\n");
		customer=customerService.fundTransfer("9876500000", "9123456789",new BigDecimal(1000.00));
		customer = customerService.showBalance("9123456789");
		System.out.print("Amount added to MobileNumber 9123456789 is: " + customer.getWallet().getBalance());
		customer = customerService.showBalance("9876500000");
		/*System.out.println("Amount is deducted     ");
		System.out.print("Balance= " + customer.getWallet().getBalance() );*/
		System.out.println("  Fund transfered Ended\n\n");
		
		

		System.out.println("Deposit Amount:\n");
		customer=customerService.depositAmount("9123456789", new BigDecimal(20000.00) );
		customer = customerService.showBalance("9123456789");
		System.out.println("Your have successfully deposited... ");
		System.out.println("Now Your Account Balance is "+customer.getWallet().getBalance());

		/*ctx.close();*/
	}
}
	
		


/* Map<String,Customer>customerdata = new HashMap<String,Customer>();
/*CustomerDAO customerdao = new WalletDAOImpl(customerdata);*/
/*CustomerService customerService = new CustomerServiceImpl(customerdao);
*/