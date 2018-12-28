package com.capgemini.service;

import com.capgemini.beans.CustomerBean;
import com.capgemini.dao.CustomerDAOImpl;
import com.capgemini.dao.CustomerDAO;
import com.capgemini.exception.CustomerException;

public class CustomerServiceImpl {
CustomerDAO customerDao;
	
	//------------------------ 1. Donor Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	addDonorDetails
	 - Input Parameters	:	donor object
	 - Return Type		:	String id
	 - Throws			:  	DonorException
	 - Author			:	CAPGEMINI
	 - Creation Date	:	11/11/2016
	 - Description		:	adding donor to database calls dao method addDonorDetails(donor)
	 ********************************************************************************************************/
	public String addCustomerDetails(CustomerBean customer) throws CustomerException {
		customerDao=new CustomerDAOImpl();	
		String customerSeq;
		customerSeq= customerDao.addCustomerDetails(customer);
		return customerSeq; 
	}
}
