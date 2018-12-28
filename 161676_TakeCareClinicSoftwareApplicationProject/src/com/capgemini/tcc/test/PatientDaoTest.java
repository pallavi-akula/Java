package com.capgemini.tcc.test;

import static org.junit.Assert.*;
import org.junit.BeforeClass;

import org.junit.Test;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.dao.PatientDAO;
import com.capgemini.tcc.exception.PatientException;




public class PatientDaoTest {

	static PatientDAO dao;
	static PatientBean patientbean;

	@BeforeClass
	public static void initialize() {
		dao = new PatientDAO();
		patientbean = new PatientBean();
	}

	@Test
	public void testAddPatientDetails() throws PatientException {

		assertNotNull(dao.addPatientDetails(patientbean));
	}
	
	/************************************
	 * Test case for addCustomerDetails()
	 * 
	 ************************************/
/*Testcases for add Patient details*/
	
	@Test
	public void testAddPatientDetails1() throws PatientException {
		assertEquals("1029", dao.addPatientDetails(patientbean));
	}


	/************************************
	 * Test case for addCustomerDetails()
	 * 
	 ************************************/

	@Test
	public void testAddPatientDetails2() throws PatientException {
		
		patientbean.setPatient_name("saibaba");
		patientbean.setPhone("1234567890");
		patientbean.setAge("22");
		patientbean.setDescription("fever");
		assertEquals("Data Inserted successfully",
				Integer.parseInt(dao.addPatientDetails(patientbean)) > 1000);

	}
}

	
