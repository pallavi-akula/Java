package com.capgemini.mainapp;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.service.CustomerServiceImpl;
import com.capgemini.beans.CustomerBean;
import com.capgemini.donorapplication.bean.DonorBean;
import com.capgemini.donorapplication.exception.DonorException;
import com.capgemini.donorapplication.service.DonorServiceImpl;
import com.capgemini.exception.CustomerException;
import com.capgemini.service.CustomerServiceImpl;
import com.capgemini.service.CustomerService;

public class MainApp {
	static Scanner sc = new Scanner(System.in);
	static CustomerService customerService = null;
	static CustomerServiceImpl customerServiceImpl = null;
	static Logger logger = Logger.getRootLogger();

	public static void main(String[] args) {
		PropertyConfigurator.configure("resources//log4j.properties");
		CustomerBean customerBean = null;

		String donorId = null;
		int option = 0;

		while (true) {

			// show menu
			System.out.println();
			System.out.println();
			
			System.out.println("_______________________________\n");

			System.out.println("1.Insert Customer ");
			System.out.println("4.Exit");
			System.out.println("________________________________");
			System.out.println("Select an option:");
			// accept option
		
	}
		try {
			option = sc.nextInt();

			switch (option) {

			case 1:

				while (customerBean == null) {
					customerBean = populateCustomer();
					// System.out.println(donorBean);
				}

				try {
					customerService = new CustomerServiceImpl();
					customerId = customerService.addCustomerDetails(customerBean);

					System.out
							.println("Customer details  has been successfully registered ");
					System.out.println("Customer  ID Is: " + customerId);

				} catch (CustomerException customerException) {
					logger.error("exception occured", customerException);
					System.out.println("ERROR : "
							+ customerException.getMessage());
				} finally {
					CustomerId = null;
					customerService = null;
					customerBean = null;
				}
			

				break;
				case 4:

					System.out.print("Exit Trust Application");
					System.exit(0);
					break;
				default:
					System.out.println("Enter a valid option[1-2]");
				}// end of switch
			}

			catch (InputMismatchException e) {
				sc.nextLine();
				System.err.println("Please enter a numeric value, try again");
			}

	
	}


private static CustomerBean getCustomerDetails(String customerId) {
	CustomerBean donorBean = null;
	customerService = new CustomerServiceImpl();

	try {
		//donorBean = customerService.viewonorDetails(donorId);
	} catch (CustomerException donarException) {
		logger.error("exception occured ", donarException);
		System.out.println("ERROR : " + donarException.getMessage());
	}

	customerService = null;
	return donorBean;
}

/*
 * This function will be called by main and will return a validated bean
 * object OR null if details are invalid
 */
private static CustomerBean populateDonorBean() {

	// Reading and setting the values for the donorBean
	
	CustomerBean customerBean = new CustomerBean();;

	System.out.println("\n Enter Details");

	System.out.println("Enter donor name: ");
	customerBean.setDonorName(sc.next());

	System.out.println("Enter donor contact: ");
	customerBean.setPhoneNumber(sc.next());

	System.out.println("Enter donor address: ");
	customerBean.setAddress(sc.next());

	System.out.println("Enter donation amount: ");

	try {
		customerBean.setDonationAmount(sc.nextFloat());
	} catch (InputMismatchException inputMismatchException) {
		sc.nextLine();
		System.err
				.println("Please enter a numeric value for donation amount, try again");
		}

	customerServiceImpl = new CustomerServiceImpl();

	try {
		customerServiceImpl.validateCustomer(customerBean);
		return customerBean;
	} catch (CustomerException customerException) {
		logger.error("exception occured", customerException);
		System.err.println("Invalid data:");
		System.err.println(customerException.getMessage() + " \n Try again..");
		System.exit(0);

	}
	return null;

}
}

