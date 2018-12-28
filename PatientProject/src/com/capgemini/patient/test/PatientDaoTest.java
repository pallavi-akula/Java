package com.capgemini.patient.test;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.capgemini.patient.dao.PatientDaoIml;
//import com.capgemini.donorapplication.exception.DonorException;
import com.capgemini.patient.exception.PatientException;
import com.capgemini.tcc.bean.Patient;

public class PatientDaoTest {
	static PatientDaoIml dao;
	static Patient customer;

	@BeforeClass
	public static void initialize() {
		System.out.println("in before class");
		dao = new PatientDaoIml();
		customer = new Patient();
	}

	@Test
	public void testAddCustomerDetails() throws PatientException {

		assertNotNull(dao.addPatientDetails(customer));

	}            
	

	

	/************************************
	 * Test case for addDonarDetails()
	 * 
	 ************************************/

	@Ignore
	@Test
	public void testAddCustomerDetails1() throws PatientException {
		// increment the number next time you test for positive test case
		assertEquals(1001, dao.addPatientDetails(customer));
		
	}

}







	
	
