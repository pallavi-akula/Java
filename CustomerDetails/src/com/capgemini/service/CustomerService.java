package com.capgemini.service;

import com.capgemini.beans.CustomerBean;
import com.capgemini.exception.CustomerException;

public interface CustomerService {
	public String addDonorDetails(CustomerBean donor) throws CustomerException;
}
