package com.capgemini.dao;

import com.capgemini.beans.CustomerBean;
import com.capgemini.exception.CustomerException;

public interface CustomerDAO {
	public String addCustomerDetails(CustomerBean donor) throws CustomerException;
}
